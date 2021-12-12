package validation;

import entity.XMI;
import entity.tag.Entity;
import parser.XMLParserUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EntityValidation {
    public static boolean entityCheck() throws IOException {

       // String filePath = "src/main/resources/parser-test.xml";
        XMI xmi = XMLParserUtil.parserXML();

        Iterator<Entity> it = xmi.getEntities().listIterator();
        HashSet<String> entitySet = new HashSet<String>();
        while (it.hasNext()) {
            Entity e = it.next();

            if(e.getIdentity()==null)
                return false;

            else if (entitySet.contains(e.getIdentity()) == false)
                entitySet.add(e.getIdentity());
            else
                return false;


        }

        return true;
    }
}
