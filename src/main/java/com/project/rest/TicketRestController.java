package com.project.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.binding.PassangerInfo;
import com.project.binding.TicketInfo;

@RestController
public class TicketRestController {
	@GetMapping("/ticket/{ticketId}")
	public ResponseEntity<TicketInfo>getTicket(@PathVariable("ticketId") Integer ticketId){
	//logic to get ticket
		TicketInfo tinfo=new TicketInfo();
		tinfo.setTicketId(1001);
		tinfo.setTicketPnr(123456789);
		tinfo.setTicketStatus("confirmed");
		
		return new ResponseEntity<>(tinfo,HttpStatus.OK);
		
	}
	
	@PostMapping(value="/ticket", 
			produces= {"application/json" },
			consumes= {"application/json"}
	)
	public ResponseEntity<TicketInfo>bookTicket(@RequestBody PassangerInfo request){
	System.out.println(request);	
	//logic to ticket book
	TicketInfo tinfo=new TicketInfo();
	tinfo.setTicketId(1001);
	tinfo.setTicketPnr(123456789);
	tinfo.setTicketStatus("confirmed");
	return new ResponseEntity<>(tinfo,HttpStatus.CREATED);
		
	}
	@PutMapping("/ticket")
	public ResponseEntity<String>updateTicket(@RequestBody PassangerInfo request){
		System.out.println(request);
		//logic
		return new ResponseEntity<>("Ticket Update",HttpStatus.OK);
	}
	@DeleteMapping("/ticket/{ticketId}")
	public ResponseEntity<String>deleteTicket(@PathVariable("ticket Id") Integer ticketId){
		
		//logic to deleted
		return new ResponseEntity<>("Ticket Deleted",HttpStatus.OK);
	}
		
	

}
