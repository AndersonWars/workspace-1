package br.com.renan.andrade.bean;

import java.io.*;
import java.nio.file.*;

import javax.faces.bean.*;
import javax.faces.context.*;
import javax.faces.event.*;

import org.primefaces.model.*;

@ManagedBean
@RequestScoped
public class ImageBean {
	
	 public StreamedContent getImg() throws IOException {
		StreamedContent img = null;
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        }else {
            String imageId = context.getExternalContext().getRequestParameterMap().get("parCodigo");
            File f = new File("C:/Users/Renan/workspace/workspace/uploads/temp.png");
            if (f.isFile()) {
            	Path path = Paths.get(f.getAbsolutePath());
            	InputStream stream = Files.newInputStream(path);
            	img = new DefaultStreamedContent(stream);
            } else {
            	f = new File("C:/Users/Renan/workspace/workspace/uploads/"+imageId+".png");
            	if(f.isFile()){
            		Path path = Paths.get(f.getAbsolutePath());
            		InputStream stream = Files.newInputStream(path);
            		img = new DefaultStreamedContent(stream);
            	}
            	else {
            		Path path = Paths.get("C:/Users/Renan/workspace/workspace/uploads/branco.png");
            		InputStream stream = Files.newInputStream(path);
            		img = new DefaultStreamedContent(stream);
            	}
            }
            return img;
        }
    }

}
