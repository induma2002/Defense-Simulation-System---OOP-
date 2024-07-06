public class Obsever implements ObseverInterface {
    private Component[] components=new Component[5];
    private MainController mainControllerob;
    private int nextComponent;
    private int strenth;
    private String area;
    private String bmsg;

    public void setMainControllerob(MainController mainControllerob){
        this.mainControllerob = mainControllerob;
        callmainConConnecter();
    }


    public void callmainConConnecter(){
        for (Component ob : components){
            if (ob != null){
                ob.mainConConnecter(mainControllerob);
            }
        }
    }


    public void setComponents(Component components){
        this.components[nextComponent++] = components;
    }

    public void setStrenth(int strenth){
        this.strenth=strenth;
        callbuttonHideer();
    }

    public void callbuttonHideer(){
        for (Component ob : components){
            if (ob != null){
                ob.buttonHideer(strenth);
            }
        }
    }
    public void setarea(String area){
        this.area=area;
        callareaInfo();
    }
    public void callareaInfo(){
        for (Component ob : components){
            if (ob != null){
                ob.areaInfo(area);
            }
        }
    }
    public void setbmsg(String bmsg){
        this.bmsg=bmsg;
        callbrodcast();
    }
    public void callbrodcast(){
        for (Component ob : components){
            if (ob != null){
                ob.brodcast(bmsg);
            }
        }
    }



}
