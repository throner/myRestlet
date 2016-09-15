package test;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.restlet.data.Form;
import org.restlet.ext.fileupload.RestletFileUpload;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import java.net.URLDecoder;
import java.util.List;

/**
 * Created by chenjiansheng on 2016-5-20.
 */
public class HelloWorldResource extends ServerResource {
    @Override
    protected Representation get() throws ResourceException {
        String sTest = (String)getRequest().getAttributes().get("test");
        String sTest1 = (String)getRequest().getAttributes().get("test2");
        Form form = getRequest().getResourceRef().getQueryAsForm() ;    //获取查询参数
        String movie = form.getFirstValue("movie");     //获取key=movie的参数值
        String movie2 = form.getFirstValue("movie2");     //获取key=movie的参数值
        System.out.println("address:"+getRequest().getClientInfo().getAddress());
        System.out.println("port:"+getRequest().getClientInfo().getPort());
        return new StringRepresentation("hello, world,,,,,"+sTest+",,,,"+sTest1+",,,"+movie+",,,"+movie2);
    }

    @Override
    protected Representation post(Representation entity)
            throws ResourceException {
        Form form = new Form(entity);
        String name = form.getFirstValue("test_name");
        String sTest = (String)getRequest().getAttributes().get("test");
        String sTest1 = (String)getRequest().getAttributes().get("test2");
        String sResult = name+":"+sTest+":"+sTest1;
        try{

            System.out.println("tt1111:"+ URLDecoder.decode(form.getMatrixString(),"UTF-8"));//获取POST内容
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(100240);
            RestletFileUpload upload = new RestletFileUpload(factory);
            List<FileItem> items = null;
            try {
                items = upload.parseRequest(getRequest());
                System.out.println("items.size:"+items.size());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new StringRepresentation(sResult);
    }

}
