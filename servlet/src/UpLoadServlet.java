import org.apache.commons.fileupload.FileItem;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class UpLoadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "upload";
    // 上传配置
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!ServletFileUpload.isMultipartContent(req)) { // 检测是否为多媒体上传
            PrintWriter writer = resp.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory(); // 配置上传参数
        diskFileItemFactory.setSizeThreshold(MEMORY_THRESHOLD); // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        diskFileItemFactory.setRepository(new File(System.getProperty("java.io.tmpdir"))); // 设置临时存储目录

        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setFileSizeMax(MAX_FILE_SIZE); // 设置最大文件上传值
        servletFileUpload.setSizeMax(MAX_REQUEST_SIZE);// 设置最大请求值 (包含文件和表单数据)
        servletFileUpload.setHeaderEncoding("UTF-8");// 中文处理

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadDirectory = req.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;

        File uploadDir = new File(uploadDirectory);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        // 解析请求的内容提取文件数据
        try {
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);
            // 迭代表单数据
            for (FileItem fileItem : fileItems) {

                if (!fileItem.isFormField()) {
                    String fileName = new File(fileItem.getName()).getName();
                    String filePath = uploadDirectory + File.separator + fileName;
                    File storeFile = new File(filePath);
                    System.out.println(filePath);
                    fileItem.write(storeFile);
                    req.setAttribute("message", "文件上传成功！");

                }
            }
        } catch (Exception e) {
            req.setAttribute("message", "上传错误：" + e.getMessage());

        }
        // 跳转到 message.jsp
        req.getServletContext().getRequestDispatcher("/message.jsp").forward(req, resp);

    }

}
