package simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewTest {
	private void setModel(Model model) {
		String name = "gonew";
		Integer age = 27;
		model.addAttribute("name", name);
		model.addAttribute("age", age);
	}
	
	@RequestMapping("/show")
	public String showJspData(Model model) {
		setModel(model);
		return "show";
	}
	
	@RequestMapping("/byXml")
	public String showXmlData(Model model) {
		setModel(model);
		return "xmlView";
	}
	
	@RequestMapping("/byExcel")
	public String showExcelData(Model model) {
		setModel(model);
		return "excelView";
	}
	@RequestMapping("/byPdf")
	public String showPdfData(Model model) {
		setModel(model);
		return "pdfView";
	}
}
