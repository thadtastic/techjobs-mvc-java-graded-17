package org.launchcode.techjobsmvc.controllers;

import org.launchcode.techjobsmvc.models.Job;
import org.launchcode.techjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.print.attribute.standard.JobName;

import java.util.ArrayList;

import static org.launchcode.techjobsmvc.controllers.ListController.columnChoices;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @GetMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.
//    how do I requestparam for a radio button??? used the form field names
    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        ArrayList<Job> jobs = null;
        if(searchTerm.equals("all") || searchTerm.isEmpty()){
            //call the findAll() method from JobData, store the results in jobs ArrayList.
            jobs = JobData.findAll();
        }else{
            //Otherwise, send the search information to findByColumnAndValue, store the results in jobs ArrayList.
            model.addAttribute("jobs", jobs);
            //copied from search method.
            model.addAttribute("columns", columnChoices);


        }
        return "search";
    }

}

