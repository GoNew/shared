package jdbc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@org.springframework.stereotype.Controller
public class Controller {
	private final static Logger LOG = LoggerFactory.getLogger(Controller.class);
	
	@RequestMapping(value="/ajax", method=RequestMethod.GET)
	public String showAjax() {
		return "ajax";
	}
	
	@RequestMapping(value="/ajax", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public @ResponseBody String responseMsg(@RequestParam String msg, HttpServletResponse response) {
		return msg;
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public String showUploadForm() {
		return "fileupload";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String uploadDone(@RequestParam("uploadFile") MultipartFile file, @RequestParam String string, Model model) throws IOException {
		String fileName = file.getOriginalFilename();
		file.transferTo(new File("c:/db/uploaded/" + fileName));
		LOG.trace("수업: " + string);
		model.addAttribute("imgname", fileName);
		return "done";
	}
}
