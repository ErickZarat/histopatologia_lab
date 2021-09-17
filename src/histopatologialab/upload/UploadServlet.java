package histopatologialab.upload;

import histopatologialab.core.JsonResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import static histopatologialab.core.ServletHelper.returnJson;

@WebServlet(name = "UploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        List<String> addedImages = new ArrayList<String>();
        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {

                for (Object item: upload.parseRequest(request)) {
                    FileItem file = (FileItem) item;
                    if (!file.isFormField()) {
                        try {         
                        	long sizeFile = (file.getSize() /(1024*1024)); 
                        	long maxSizeFile = 4; 
                        	if (sizeFile < maxSizeFile )  // solo las imagenes con la cantidad permitida 
                        	{                        	
	                        	String ext = FilenameUtils.getExtension(file.getName());  // agregado 
	                    		String nameWithoutExt = FilenameUtils.getBaseName(file.getName());    // agregado 
	                    		String itemName = nameWithoutExt+ "-" + LocalDate.now().atStartOfDay().toEpochSecond(ZoneOffset.UTC)+"." + ext;    // agregado
	                    		// String itemName = file.getName() + "-" + LocalDate.now().atStartOfDay().toEpochSecond(ZoneOffset.UTC);                        	 
	                    		//File fileToSave = new File("/Users/erickzarat/code/me/astrid/histopatologia_lab/WebContent/assets/img/uploads/"+itemName);
	                    		File fileToSave = new File("/opt/tomcat/latest/webapps/histopatologia_lab/assets/img/uploads/"+itemName);			// servidor AWS
	                    		// File fileToSave = new File("/opt/images/lab/"+itemName);															// servidor AWS
	                    		 //File fileToSave = new File("C:\\Astrid\\EPS\\histopatologia_lab\\WebContent\\assets\\img\\uploads\\"+itemName);     //maquina local pruebas 
	                    		file.write(fileToSave);
	                    		
	                    		//addedImages.add("assets\\img\\uploads\\"+itemName);  //maquina local pruebas  
	                    		addedImages.add("assets/img/uploads/"+itemName);   // servidor
                        	}
                        	else 
                        	{
                        		 System.out.println("es mayor que 4MB");
                        	}
                        	
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            System.out.println("imagenes");
            System.out.println(addedImages.isEmpty());
            if (addedImages.isEmpty())  // si no se puso subir la imagen 
            {
            	returnJson(response, new JsonResponse<>(false, null, "Hubo error subiendo las imágenes"));
            }
            else 
            {
                returnJson(response, new JsonResponse<>(true, addedImages));
            }

        } else {
            returnJson(response, new JsonResponse<>(false, null, "error subiendo las imágenes"));
        }
    }
}
