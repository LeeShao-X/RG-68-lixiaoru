package imageupload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/imageuploadServlet")
public class imageuploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String savePath = request.getServletContext().getRealPath("/images/image_head");
        File file = new File(savePath);
        //判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(savePath+"目录不存在，需要创建");
            //创建目录
            file.mkdir();
        }
        //临时保存目录
        String tempPath = this.getServletContext().getRealPath("/images/temp");
        File tempfile = new File(tempPath);
        if (!tempfile.exists() && !tempfile.isDirectory()) {
            System.out.println(tempPath+"目录不存在，需要创建");
            //创建目录
            tempfile.mkdir();
        }

        try{
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);//创建一个文件上传解析器
            factory.setSizeThreshold(1024*100);//设定缓冲区大小，超过100k将生成临时文件并存到临时目录下
            factory.setRepository(tempfile);//临时存放目录
            upload.setHeaderEncoding("utf-8");
            if(!ServletFileUpload.isMultipartContent(request))
            {//判断提交上来的数据是否是上传表单的数据
                return ;
            }
            upload.setFileSizeMax(1024*1024*5);//单个文件允许的最大字节
            upload.setSizeMax(1024*1024*10);//文件总量最大字节
            List<FileItem> list = upload.parseRequest(request);//将表单信息放入链表
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String filename=df.format(new Date());//文件名为当前时间+车牌号
            for(FileItem item:list)
            {
                if(item.isFormField())
                {//判断是文本？
                    String name=item.getFieldName();//即name
                    String value=item.getString("utf-8");
                    if (name.equals("cgrade"))
                        filename+=value;
                    System.out.println(name+"="+value);
                }
                else
                {//文件处理
                    String fileExtName=item.getName();//上传的文件名
                    System.out.println("文件名="+filename);
                    if(fileExtName==null||fileExtName.equals(""))
                    {
                        continue;
                    }
                    fileExtName=fileExtName.substring(fileExtName.lastIndexOf("."));//获取扩展名
                    System.out.println("上传的文件的扩展名是："+fileExtName);
                    InputStream in=item.getInputStream();//文件输入流
                    FileOutputStream out=new FileOutputStream(savePath+"\\"+filename+fileExtName);
                    byte[] buffer=new byte[1024];//缓冲区
                    int len=0;
                    while ((len=in.read(buffer))>0)
                    {
                        out.write(buffer,0,len);//写入文件
                    }
                    in.close();
                    out.close();
                }
                item.delete();
            }

        }catch (FileUploadBase.FileSizeLimitExceededException e)
        {
            response.sendRedirect("managers/addhead.jsp");//单个文件太大
            return;
        }catch (FileUploadBase.SizeLimitExceededException e)
        {
            response.sendRedirect("managers/addhead.jsp");//整体文件太大
            return;
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        response.sendRedirect("managers/showimage.jsp");
        // response.sendRedirect("main/mian.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
