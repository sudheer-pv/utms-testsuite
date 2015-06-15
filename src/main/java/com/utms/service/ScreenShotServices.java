package com.utms.service;
/*
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;*/
import org.springframework.web.bind.annotation.RestController;
/*
import com.utms.entity.TestCaseResults;
import com.utms.repo.AutoTestCaseResultsRepository;

*/
@RestController


public class ScreenShotServices {
	/*
	@RequestMapping(value = "/screenShot", method = RequestMethod.GET)
	@Transactional
	
	public @ResponseBody String getScreenShot(@RequestParam(value = "exeRunId", required = true) Integer exeRunId, @RequestParam(value = "testCaseResultId", required = true) Integer testCaseResultId){
		String imageDataString = "";
		testCaseResults = autoTestCaseResultsRepository.findTestCaseResultsByIdAndExeRunId(testCaseResultId, exeRunId);
		String screenShotDir = testCaseResults.getScreenShotDir();
		File file = new File(screenShotDir);
		try {            
            // Reading a Image file from file system
            FileInputStream imageInFile = new FileInputStream(file);
            byte imageData[] = new byte[(int) file.length()];
            imageInFile.read(imageData);
 
            // Converting Image byte array into Base64 String
            imageDataString = encodeImage(imageData);
 
            // Converting a Base64 String into Image byte array
            byte[] imageByteArray = decodeImage(imageDataString);
 
            // Write a image byte array into file system
            FileOutputStream imageOutFile = new FileOutputStream(
                    "/Users/jeeva/Pictures/wallpapers/water-drop-after-convert.jpg");
 
            imageOutFile.write(imageByteArray);
 
            imageInFile.close();
//            imageOutFile.close();
 
            System.out.println("Image Successfully Manipulated!");
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }
		return "data:image/png;base64,"+imageDataString;
		
	}
	
	public static String encodeImage(byte[] imageByteArray) {
        return Base64.encodeBase64URLSafeString(imageByteArray);
    }
	
	
	@Autowired
	AutoTestCaseResultsRepository autoTestCaseResultsRepository;
	
	@Autowired
	TestCaseResults testCaseResults;*/

}
