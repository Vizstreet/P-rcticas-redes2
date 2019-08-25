/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;
/**
 *
 * @author josue
 */
public class textProcessing {
    private final dotEnv env;
    private Stream<String> vocabulary;
    
    public textProcessing() {
        this.env = new dotEnv();
    }
    
    public List<String> processText(String text, String[] stop_words) {
        PythonInterpreter Interpreter = new PythonInterpreter();
        Interpreter.execfile(this.env.getProcessTextPythonFile());
        PyFunction ProcessTextFunction = (PyFunction)Interpreter.get("process", PyFunction.class);
        PyObject clean_text = ProcessTextFunction.__call__(new PyString(text.toLowerCase()),Py.java2py(stop_words));
        List<String> array_text =Arrays.asList((Py.tojava(clean_text, String.class)).split(" "));
        this.vocabulary = array_text.stream().distinct();
        return array_text;
    }
    public String[] getStopWords() throws UnsupportedEncodingException {
     PythonInterpreter Interpreter = new PythonInterpreter();
     Interpreter.execfile(this.env.getProcessTextPythonFile());
     PyFunction StopWordsFunction = (PyFunction)Interpreter.get("get_stop_words", PyFunction.class);
     PyObject py_stop_words = StopWordsFunction.__call__(new PyString(this.env.getStopWordsFile()));
     String stop_words = (Py.tojava(py_stop_words, String.class));
     return stop_words.split(" ");
    }
    public Map<String,Integer> createDictionary(List<String> tokens) {
        Map<String,Integer> dictionary = new HashMap<>();
        tokens.forEach((token) -> {
            if(dictionary.get(token)== null) {
                dictionary.put(token, 1);
            } else {
                dictionary.put(token, dictionary.get(token)+1);
            }
        });
        return dictionary;
    }
    
}
