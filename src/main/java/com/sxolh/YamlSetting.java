package com.sxolh;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

public class YamlSetting {
        private Map<String, Object> contents;
        private String pathSeperator = "\\";

        public YamlSetting() throws IOException {
            if (System.getProperty("os.name").equals("Linux")) this.pathSeperator = "/";
            this.contents = getYamlData("."+pathSeperator+"Setting.yaml");
        }

        private Map<String, Object> getYamlData(String fileDirectory) throws IOException {
                InputStream inputStream = null;
                try {
                        inputStream = new FileInputStream(new File(fileDirectory));
                } catch (FileNotFoundException ex) {
                    throw new IOException("File not found");
                }

                Yaml yaml = new Yaml();
                Map<String, Object> data = yaml.load(inputStream);
                return data;
        }

        public Object getValue(String key) throws IOException{
                if(contents.get(key) == null) throw new IOException("Key Not Found");
                return contents.get(key);
        }

        @Override
        public String toString() {
                return "YamlFile{" + contents + '}';
        }

}
