/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.datos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Modelo.Ventas;
import Modelo.VentasDetalles;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.io.IOException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class GeneraDoc {

    VentasDAO vdao = VentasDAO.getVentasDAO();
    VentasDetallesDAO vddao = VentasDetallesDAO.getVentasDetallesDAO();
    List<Ventas> datos = vdao.consultar();
    List<VentasDetalles> datosvd;
    int y = -1;

    

    public void generaExcel() {

        String nombreArchivo = "Ventas.xlsx";
        String rutaArchivo = "C:\\Ficheros-Excel\\" + nombreArchivo;
        String hoja = "Hoja1";

        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja1 = libro.createSheet(hoja);
        //cabecera de la hoja de excel
        String[] header = new String[]{"#Venta",
            "Fecha",
            "Total a pagar",
            "CantPagada",
            "Comentarios",
            "Tipo de venta",
            "Cliente",
            "Sucursal",
            "Empleado",
            "Estado de venta",
            "",
            "#Venta",
            "Precio de venta",
            "Cantidad",
            "Subtotal",
            "Preentacion",
            "Estado de producto solicitado"};

        //contenido de la hoja de excel
        String[][] document = new String[vdao.numVD()][17];

        for (int x = 0; x < vdao.numV(); x++) {
//                System.out.println("Linea x: " + x + "Linea y: " + y);
//                System.out.println(document[x][y]);
            document[x][0] = String.valueOf(datos.get(x).getIdVenta());
            document[x][1] = String.valueOf(datos.get(x).getFecha());
            document[x][2] = String.valueOf(datos.get(x).getTotalPagar());
            document[x][3] = String.valueOf(datos.get(x).getCantPagada());
            document[x][4] = String.valueOf(datos.get(x).getComentarios());
            document[x][5] = String.valueOf(datos.get(x).getTipo());
            document[x][6] = String.valueOf(datos.get(x).getIdCliente());
            document[x][7] = String.valueOf(datos.get(x).getIdSucursal());
            document[x][8] = String.valueOf(datos.get(x).getIdEmpleado());
            document[x][9] = String.valueOf(datos.get(x).getEstatus());
            document[x][10] = "";
            datosvd = vddao.consultarId(datos.get(x).getIdVenta());
            for (int i = 0; i < datosvd.size(); i++) {
                y++;
                document[y][11] = String.valueOf(datos.get(x).getIdVenta());
                document[y][12] = String.valueOf(datosvd.get(i).getPrecioVenta());
                document[y][13] = String.valueOf(datosvd.get(i).getCantidad());
                document[y][14] = String.valueOf(datosvd.get(i).getSubtotal());
                document[y][15] = String.valueOf(datosvd.get(i).getIdPresentacion());
                document[y][16] = String.valueOf(datosvd.get(i).getEstatus());
            }

        }

        //poner negrita a la cabecera
        CellStyle style = libro.createCellStyle();
        Font font = libro.createFont();
        font.setBold(true);
        style.setFont(font);

        //generar los datos para el documento
        for (int i = 0; i <= document.length; i++) {
            XSSFRow row = hoja1.createRow(i);//se crea las filas
            for (int j = 0; j < header.length; j++) {
                if (i == 0) {//para la cabecera
                    XSSFCell cell = row.createCell(j);//se crea las celdas para la cabecera, junto con la posición
                    cell.setCellStyle(style); // se añade el style crea anteriormente 
                    cell.setCellValue(header[j]);//se añade el contenido					
                } else {//para el contenido
                    XSSFCell cell = row.createCell(j);//se crea las celdas para la contenido, junto con la posición
                    cell.setCellValue(document[i - 1][j]); //se añade el contenido
                }
            }
        }

        File file;
        file = new File(rutaArchivo);
        try (FileOutputStream fileOuS = new FileOutputStream(file)) {
            if (file.exists()) {// si el archivo existe se elimina
                file.delete();
                System.out.println("Archivo eliminado");
            }
            libro.write(fileOuS);
            fileOuS.flush();
            fileOuS.close();
            System.out.println("Archivo Creado");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void generaPDF() {

    }
    
    public void generarXML(){
         try {
      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
      //Elemento raíz
      Document doc = docBuilder.newDocument();
      
      Element rootElement = doc.createElement("idventa");
      doc.appendChild(rootElement);
      Attr attr = doc.createAttribute("id");
      attr.setValue(String.valueOf(datos.get(0).getIdVenta()));
      rootElement.setAttributeNode(attr);
      //Primer elemento
      Element elemento1 = doc.createElement("fecha");
      elemento1.setTextContent(String.valueOf(datos.get(0).getFecha()));
      rootElement.appendChild(elemento1);
      //Se agrega un atributo al nodo elemento y su valor
//      Attr attr = doc.createAttribute("id");
//      attr.setValue("valor del atributo");
//      elemento1.setAttributeNode(attr);
      Element elemento2 = doc.createElement("elemento2");
      elemento2.setTextContent("Contenido del elemento 2");
      rootElement.appendChild(elemento2);
      //Se escribe el contenido del XML en un archivo
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(doc);
      StreamResult result = new StreamResult(new File("C:\\Ficheros-Excel\\prueba.xml"));
      transformer.transform(source, result);
    } catch (ParserConfigurationException pce) {
      pce.printStackTrace();
    } catch (TransformerException tfe) {
      tfe.printStackTrace();
    }
         System.out.println("jala");
    }

}
