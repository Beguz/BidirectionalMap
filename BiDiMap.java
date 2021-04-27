package bidimain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BiDiMap {

    private Map<String, String> telefonKonyv = new HashMap<>();

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.telefonKonyv);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BiDiMap other = (BiDiMap) obj;
        if (!Objects.equals(this.telefonKonyv, other.telefonKonyv)) {
            return false;
        }
        return true;
    }

    public int kiir() {
        return telefonKonyv.size();
    }

    public void put(String nev, String telSzam) {
        if (this.telefonKonyv.containsKey(nev)) {
            this.telefonKonyv.remove(nev);
        }
        if (this.telefonKonyv.containsValue(telSzam)) {
            for (Map.Entry<String, String> entry : telefonKonyv.entrySet()) {
                if (entry.getValue().equals(telSzam)) {
                    telefonKonyv.remove(entry.getKey());
                }
            }
        }
        telefonKonyv.put(nev, telSzam);
    }

    /*
    public Map<String, String> get(String kulcs){
        for (Map.Entry<String, String> entry : telefonKonyv.entrySet()) {
            if(entry.getKey().equals(kulcs)){
                Map<String, String>temp= new HashMap<>();
                temp.put(entry.getKey(), entry.getValue());
                return temp;
            }
        }
        return null;
    }
     */
    public String get(String kulcs) {
        return telefonKonyv.get(kulcs);
    }

    public String getInverse(String ertek) {
        for (Map.Entry<String, String> entry : telefonKonyv.entrySet()) {
            if (entry.getValue().equals(ertek)) {
                return entry.getKey();
            }
        }
        return null;
    }

    /*
    public Map<String, String> getInverse(String ertek){
        for (Map.Entry<String, String> entry : telefonKonyv.entrySet()) {
            if(entry.getValue().equals(ertek)){
                Map<String, String>temp= new HashMap<>();
                temp.put(entry.getKey(), entry.getValue());
                return temp;
            }
        }
        return null;
    }
     */
    public void remove(String kulcs) {
        this.telefonKonyv.remove(kulcs);
    }

    public void removeInverse(String ertek) {
        for (Map.Entry<String, String> entry : telefonKonyv.entrySet()) {
            if (entry.getValue().equals(ertek)) {
                telefonKonyv.remove(entry.getKey());
                return;
            }
        }
    }

    public BiDiMap getInverse() {
        BiDiMap temp = new BiDiMap();
        for (Map.Entry<String, String> entry : this.telefonKonyv.entrySet()) {
            temp.put(entry.getValue(), entry.getKey());
        }
        return temp;
    }

    public int size() {
        return this.telefonKonyv.size();
    }

}
