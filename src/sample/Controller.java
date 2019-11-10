package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;



public class Controller {

    @FXML
    private Label dog;

    @FXML
    private Button Attack;

    @FXML
    private Button Upgrade;

    public int doghp;
    public int dogLevel;
    public int damage;
    public int money;
    public int score;
    public int upgradeCost;
    public int currdoghp;

    public void initialize(){
        doghp =10;
        currdoghp=10;
        dogLevel=1;
        damage=1;
        money=0;
        score=0;
        upgradeCost=1;

        gui();

        update();

//        dog.setText("DogNo: #"+dogLevel+" ["+doghp+ " HP]" + " Wallet: Rs"+ money + "Damage: "+ damage);



    }
    public void update(){
        dog.setText("DogNo: #"+dogLevel+" ["+doghp+ " HP]" + " Wallet: Rs "+ money + "Damage: "+ damage);
    }
    public void gui() {
        Attack.setOnAction(e -> {
                if ((doghp - damage) <= 0) { //yeah
                    dogLevel += 1;
                    money=money+2;
                    currdoghp=currdoghp*2;
                    doghp=currdoghp;
                    score=score+damage;
                    upgradeCost = upgradeCost+currdoghp/30;
                    System.out.println("DogLevel up");
//                     dog.setText("DogNo: #"+dogLevel+" ["+doghp+ " HP]" + " Wallet: Rs "+ money + "Damage: "+ damage);
                }else{
                    doghp=doghp-damage;
                }
                update();

            }

        );
        Upgrade.setOnAction(e ->{
            if(money-upgradeCost<0){
                System.out.println("Insufficient money");
            }else{
                damage=damage+1;
                money=money-upgradeCost;
                ;
            }
            update();
        });


        }




}
