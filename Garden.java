package exercises.garden;

import exercises.garden.exceptions.AlreadySownException;
import exercises.garden.exceptions.BiodiversityException;
import exercises.garden.exceptions.GardenSpaceException;
import exercises.garden.exceptions.SurfaceException;
import exercises.garden.interfaces.Plantable;

public class Garden implements Plantable {
    private int surface;
    private Vegetable[] vegetables;
    private final int MIN_GARDEN_SURFACE = 5;
    private final int MAX_BIODIVERSITY = 50;
    private final int PLANTS_FOR_M2 = 10;
    private int plantsSown;
    private int biodiversity;
    private Vegetable[] cultivarList;

    public Garden(int surface) throws Exception{
        if(surface >= MIN_GARDEN_SURFACE) this.surface = surface;
        else throw new SurfaceException(MIN_GARDEN_SURFACE);
        this.vegetables = new Vegetable[0];
        this.cultivarList = new Vegetable[MAX_BIODIVERSITY+1];
    }

    /**
     * Plant a Vegetable in Garden
     * @param vegetable which vegetable we want to plant
     * @param numberOfPlants how many plants we want plant
     * */
    public void plant(Vegetable vegetable, int numberOfPlants){
        try {
            if(!isAlreadyInGarden(vegetable)) {
                if(biodiversity+1 <= MAX_BIODIVERSITY) {
                    for(int i = 0; i < numberOfPlants; i++){
                        if(isThereSpaceInGarden()){
                            vegetables = Vegetable.pushVegetableInList(vegetables, vegetable);
                            plantsSown++;
                        }else {
                            throw new GardenSpaceException(numberOfPlants - i);
                        }
                    }
                    cultivarList[biodiversity] = vegetable;
                    biodiversity++;
                }else throw new BiodiversityException();
            }else throw new AlreadySownException(vegetable);
        }catch (Exception e){
            System.out.println("Vegetable cannot be added: "  +e);
        }
    }

    private boolean isAlreadyInGarden(Vegetable vegetable){
        for(Vegetable v : vegetables){
            if(v.getName().equals(vegetable.getName())) return true;
        }
        return false;
    }

    private boolean isThereSpaceInGarden(){
        if(((double)plantsSown / surface) < PLANTS_FOR_M2) return true;
        return false;
    }

    private String displayVegetablesList(){
        String list = "";
        for(Vegetable cultivar : cultivarList){
            if(cultivar == null) break;
            list+= "\n" + cultivar.getName() + ":";
            list+= "\n  " + cultivar.getSowingDate();
            list+= "\n  " + cultivar.getHarvestDate();
            int typeCounter = 0;
            for(Vegetable v : vegetables){
                if(v.getName().equals(cultivar.getName())) typeCounter++;
            }
            list+="\n  plants number: " + typeCounter;
        }
        return list;
    }
    // getters
    public int getSurface() {
        return surface;
    }

    public Vegetable[] getVegetables() {
        return vegetables;
    }
    public int getPlantsSown() {
        return plantsSown;
    }


    @Override
    public String toString(){
        return "\nGarden surface: " + getSurface() + "\nPlants sown: " + getPlantsSown() + "\nVegetables: " + displayVegetablesList();
    }
}
