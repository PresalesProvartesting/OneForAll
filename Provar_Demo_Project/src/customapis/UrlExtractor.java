package customapis;


import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.provar.core.model.base.api.ValueScope;
import com.provar.core.testapi.ITestExecutionContext;
import com.provar.core.testapi.annotations.*;

@TestApi( title="Url Extractor"
        , summary=""
        , remarks=""
        , iconBase=""
        , defaultApiGroups={"My Custom Api's"}
        )
@TestApiParameterGroups(parameterGroups={
	    @TestApiParameterGroup(groupName="inputs", title="Inputs"),
	    @TestApiParameterGroup(groupName="result", title="Result"),
	    })
public class UrlExtractor {
    
    @TestApiParameter(seq=1, 
            summary="The first parameter's summary.",
            remarks="",
            mandatory=true,
            parameterGroup="inputs")
    public String InputText;
    
    @TestApiParameter(seq=1, 
            summary="The first parameter's summary.",
            remarks="",
            mandatory=false,
            parameterGroup="inputs")
    public String SearchString;
    

    @TestApiParameter(seq=10, 
            summary="The name that the result will be stored under.",
            remarks="",
            mandatory=true,
            parameterGroup="result")
    public String resultName;
    

    @TestApiParameter(seq=11, 
            summary="The lifespan of the result.",
            remarks="",
            mandatory=true,
            parameterGroup="result",
            defaultValue="Test")
    public ValueScope resultScope;

    /** 
     * Used to write to the test execution log.
     */
    @TestLogger
    public Logger testLogger;
    
    /** 
     * Provides access to facilities, mainly to set and get variable values.
     */
    @TestExecutionContext
    public ITestExecutionContext testExecutionContext;
    
    @TestApiExecutor
    public void execute() {

    	// Put our implementation logic here.
    	try {
    	ArrayList links = new ArrayList();
		String regex = "[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";
    	//String regex = "^(?:http(s)?:\\/\\/)?[\\w.-]+(?:\\.[\\w\\.-]+)+[\\w\\-\\._~:/?#[\\]@!\\$&'\\(\\)\\*\\+,;=.]+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(InputText);
		while(m.find()) {
		String urlStr = m.group();
		if (urlStr.startsWith("(") && urlStr.endsWith(")"))
		{
		urlStr = urlStr.substring(1, urlStr.length() - 1);
		}
		links.add(urlStr);
		}
		
		ArrayList matchingurl = new ArrayList();
		if(SearchString.equals("All Links")) {
			for(int x= 0; x<links.size(); x++) {
				String match1 = (String) links.get(x);
				matchingurl.add(match1);
			}
		}
		else {
		String[]wo = SearchString.split("\\r?\\n");
		String abcd = null;
		for(int j = 0; j<wo.length; j++) {
		for(int i =0;i<links.size();i++) {
		String match = (String) links.get(i);
		if(match.contains(wo[j])) {
			abcd = match;
			matchingurl.add(abcd);
		}
		}
		}
		}
    	testLogger.info("All Links -  "  + links);

        // Store the result (if appropriate).
    	ArrayList dummyResult = matchingurl;
        testExecutionContext.setValue(resultName, dummyResult, resultScope);
    	}
    	catch(Exception e) {
    		
    	}
    }
    
}
