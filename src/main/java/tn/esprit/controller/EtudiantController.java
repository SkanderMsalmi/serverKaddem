package tn.esprit.controller;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.persistance.entities.*;


import tn.esprit.service.interfaces.EtudiantService;

@RestController
@RequestMapping("/ControleurEtudiant")
@CrossOrigin(origins = "http://localhost:4200")
public class EtudiantController {

	@Autowired
	EtudiantService eServ;
	

	
	@GetMapping("/displayStudent/{id}")
	public Etudiant displayStudent(@PathVariable("id")int id) {
		Etudiant e = eServ.retrieveEtudiant(id);
		if (e.getProfileImage()!=null)
		e.setProfileImage(decompressBytes(e.getProfileImage()));
		return e;
	}

	@GetMapping("/displayStudents")
	public List<Etudiant> displayAllStudents(){
		List<Etudiant> e = eServ.retrieveAllEtudiants();
		e.forEach(et->{ 
			if (et.getProfileImage()!=null)
			et.setProfileImage(decompressBytes(et.getProfileImage()));
			});
		return e;
	}
	
	@PostMapping(value="/addStudent", consumes= {MediaType.MULTIPART_FORM_DATA_VALUE})
	public Etudiant addStudent( @RequestPart("etudiant") Etudiant e, @RequestPart("image") MultipartFile f) {
		try {
			e.setProfileImage(compressBytes(f.getBytes()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return eServ.addEtudiant(e);
	}
	
	@PutMapping("/updateStudent")
	public Etudiant updateStudent(@RequestBody Etudiant e) {
		return eServ.updateEtudiant(e);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable("id")int id) {
		eServ.removeEtudiant(id);
	}
	
	@PostMapping("/assignEtudToDepart/{idEtudiant}/{idDepart}")
	public void assignEtudiantToDepartement(@PathVariable("idEtudiant") int idEtudiant,@PathVariable("idDepart") int idDepart) {
		try {
			eServ.assignEtudiantToDepartement(idEtudiant, idDepart);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	
	@PostMapping("/addAndAssignEtudiantToEquipeAndContract/{idEquip}/{idContrat}")
	public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@PathVariable("idContrat") int idContrat,@PathVariable("idEquip") int idEtudiant) {
		try {
			return eServ.addAndAssignEtudiantToEquipeAndContract(e, idContrat, idEtudiant);
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println(e2);
			return null;
		}
	}
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		return outputStream.toByteArray();
	}
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
}