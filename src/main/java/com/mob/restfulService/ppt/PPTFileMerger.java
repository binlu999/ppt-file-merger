package com.mob.restfulService.ppt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.json.JSONObject;

public class PPTFileMerger {

	public String merge(JSONObject jsonObject) {
		System.out.println("start .. now");
		// creating empty presentation
		XMLSlideShow ppt = new XMLSlideShow();

		// taking the two presentations that are to be merged
		String file1 = "C:/tmp/ppt/wo-yao-song-yang.pptx";
		String file2 = "C:/tmp/ppt/zhu-shi-wo-li-liang.pptx";
		String[] inputs = { file1, file2 };

		try {

			for (String arg : inputs) {
				FileInputStream inputstream = new FileInputStream(arg);
				XMLSlideShow src = new XMLSlideShow(inputstream);

				for (XSLFSlide srcSlide : src.getSlides()) {

					// merging the contents
					ppt.createSlide().importContent(srcSlide);
				}
			}

			String file3 = "C:/tmp/ppt/combinedpresentation.pptx";

			// creating the file object
			FileOutputStream out = new FileOutputStream(file3);

			// saving the changes to a file
			ppt.write(out);
			System.out.println("Merging done successfully");
			out.close();
		} catch (IOException e) {
			return "Exception";
		}
		return "Success";
	}
}
