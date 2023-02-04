import java.util.Objects;

public class Avenger implements Comparable <Avenger>{
	
	private String heroName;
    private String heroAlias;
    private int frequency;

	// TODO: Implement the Avenger Class
    
    public String getHeroName() {
        return heroName;
    }
    
    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }
    
    public String getHeroAlias() {
        return heroAlias;
    }
    
    public void setHeroAlias(String heroAlias) {
        this.heroAlias = heroAlias;
    }
    
    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    
	@Override
	public int compareTo(Avenger other) {
		
		return this.heroAlias.compareTo(other.heroAlias);
	}
	
	public boolean equals(Object o) {
		
        if (this == o) return true;
        
        if (o == null || getClass() != o.getClass()) return false;
        
        Avenger avenger = (Avenger) o;
        
        return Objects.equals(heroAlias, avenger.heroAlias);
    
   

	}
	
	// TODO Auto-generated method stub
    public String toString() {
        return heroAlias + " aka " + heroName + " mentioned " + frequency + " time(s)";
    }

}
 