package com.medicapp.restcontroller;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medicapp.data.model.Drug;
import com.medicapp.service.DrugService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/medicapp/drugs")
public class DrugController {

	@Autowired
	private DrugService drugService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public List<Drug> getAllDrugs() {
		return drugService.getAllDrugs();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{name}")
	public List<Drug> searchDrugs(@PathVariable String name) {
		return drugService.searchDrugName(name);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/consult/{idcons}")
	public List<Drug> getDrugPrescript(@PathVariable int idcons) {
		return drugService.getDrugPrescript(idcons);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/pdf/{idstaff}/{idconsult}")
	public void generatePrescript(@PathVariable int idstaff, @PathVariable int idconsult,
			@RequestBody List<Drug> drugs) {
		drugService.generatePrescript(drugs, idstaff, idconsult);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/pdf")
	public String getPdf() {
		ByteArrayOutputStream ba = DrugService.loadPdf();
		String pdfBase64String = org.apache.commons.codec.binary.StringUtils
				.newStringUtf8(org.apache.commons.codec.binary.Base64.encodeBase64(ba.toByteArray()));
		return pdfBase64String;
	}
}
