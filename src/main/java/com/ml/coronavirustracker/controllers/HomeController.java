
 package com.ml.coronavirustracker.controllers;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import
org.springframework.web.bind.annotation.GetMapping;

import com.ml.coronavirustracker.models.LocationStats;
import com.ml.coronavirustracker.services.CoronaVirusDataService;

@Controller public class HomeController {
	
	@Autowired
	CoronaVirusDataService coronaVirusDataService;
 
@GetMapping("/") 
public String index(Model model) {
	List<LocationStats>allStats = coronaVirusDataService.getAllStats();
	int totalReportedCases = allStats.stream().mapToInt(stat ->stat.getLastestTotalCases()).sum();
	model.addAttribute("locationStats", allStats);
	model.addAttribute("totalReportedCases", totalReportedCases);
	
	return "index.jsp"; }
 
 }
