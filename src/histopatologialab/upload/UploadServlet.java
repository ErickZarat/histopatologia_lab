package histopatologialab.upload;

import histopatologialab.core.JsonResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
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
                            String itemName = file.getName();
                            File fileToSave = new File("/Users/erickzarat/code/me/astrid/histopatologia_lab/WebContent/assets/img/uploads/"+itemName);
                            file.write(fileToSave);

                            addedImages.add("assets/img/uploads/"+itemName);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

            } catch (FileUploadException e) {
                e.printStackTrace();
            }

            returnJson(response, new JsonResponse<>(true, addedImages));

        } else {
            returnJson(response, new JsonResponse<>(false, null, "error subiendo las imagenes"));
        }
    }
}
