package com.pendurpandurok.sziporka;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pendurpandurok.sziporka.Screens.Menu.MenuStage;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class Upgrade {
        OneSpriteStaticActor upgrd;
        OneSpriteStaticActor coin;
        OneSpriteStaticActor icon;
        OneSpriteStaticActor front;
        MyLabel qwe;
        MyLabel ar;
        MyLabel plus;
        final int money = 0;
        public float lvl = 0;
        public int levelup = 0;
        public String level = "";
        public int melyik = 0;
        public float mennyikene = 0;

    public Upgrade(final MenuStage gs, String name, final Integer hanyadik){


        //0 => pénz
        //1 => áram
        //2 => veszt
        //3 => Tűrőképesség
        //4 => ÚJ PART
        upgrd = new OneSpriteStaticActor(Assets.manager.get(Assets.UPGRD));
        upgrd.setWidth(gs.getViewport().getWorldWidth()/1.2f);
        upgrd.setHeight(upgrd.getWidth()/4.31f);
        upgrd.setPosition(gs.getViewport().getWorldWidth()/2-upgrd.getWidth()/2,upgrd.getHeight()*hanyadik+gs.getViewport().getWorldHeight()/20);
        gs.addActor(upgrd);

        if(name == "Generátor"){
            if(hanyadik == 0){
                qwe = new MyLabel("Áram termelés",gs.game.getLabelStyle());
                melyik = 1;
                lvl = gs.game.save.getFloat("aram_termeles");
                level = "aram_termeles";
            }
            else if(hanyadik == 1){
                qwe = new MyLabel("Áramból pénz",gs.game.getLabelStyle());
                melyik = 0;
                lvl = gs.game.save.getFloat("aram_to_penz");
                level = "aram_to_penz";
            }
            else if(hanyadik == 2){
                qwe = new MyLabel("Áttételek",gs.game.getLabelStyle());
                melyik = 2;
                lvl = gs.game.save.getFloat("attetelek");
                level = "attetelek";
            }
            else if(hanyadik == 3){
                qwe = new MyLabel("Türöképesség",gs.game.getLabelStyle());
                melyik = 3;
                lvl = Math.round(gs.game.save.getFloat("turokepesseg_generator"));
                level = "turokepesseg_generator";
            }
            else {
                qwe = new MyLabel("ÚJ GENERÁTOR",gs.game.getLabelStyle());
                melyik = 4;
                lvl = (12*(gs.game.save.getFloat("generator_lvl")+1))-(gs.game.save.getFloat("aram_termeles") + gs.game.save.getFloat("aram_to_penz") + gs.game.save.getFloat("attetelek") + Math.round(gs.game.save.getFloat("turokepesseg_generator")));
                level = "generator_lvl";
                mennyikene = 12*(gs.game.save.getFloat("generator_lvl")+1);
            }
        }
        else if(name == "Lapát"){
            if(hanyadik == 0){
                qwe = new MyLabel("Forgási sebesség",gs.game.getLabelStyle());
                melyik = 1;
                lvl = gs.game.save.getFloat("forgasi_sebesseg");
                level = "forgasi_sebesseg";
            }
            else if(hanyadik == 1){
                qwe = new MyLabel("Fogaskerekek",gs.game.getLabelStyle());
                melyik = 2;
                lvl = gs.game.save.getFloat("fogaskerekek");
                level = "fogaskerekek";
            }
            else if(hanyadik == 2){
                qwe = new MyLabel("Lapátok mérete",gs.game.getLabelStyle());
                melyik = 1;
                lvl = gs.game.save.getFloat("lapatok_merete");
                level = "lapatok_merete";
            }
            else if(hanyadik == 3){
                qwe = new MyLabel("Kerék mérete",gs.game.getLabelStyle());
                melyik = 1;
                lvl = gs.game.save.getFloat("kerek_merete");
                level = "kerek_merete";
            }
            else if(hanyadik == 4){
                qwe = new MyLabel("Türöképesség",gs.game.getLabelStyle());
                melyik = 3;
                lvl = Math.round(gs.game.save.getFloat("turokepesseg_lapat"));
                level = "turokepesseg_lapat";
            }
            else {
                qwe = new MyLabel("ÚJ LAPÁT",gs.game.getLabelStyle());
                melyik = 4;
                lvl = (15*(gs.game.save.getFloat("lapat_lvl")+1))-(gs.game.save.getFloat("forgasi_sebesseg") + gs.game.save.getFloat("fogaskerekek") + gs.game.save.getFloat("lapatok_merete") + gs.game.save.getFloat("kerek_merete") + Math.round(gs.game.save.getFloat("turokepesseg_lapat")));
                level = "lapat_lvl";
                mennyikene = 15*(gs.game.save.getFloat("lapat_lvl")+1);
            }
        }
        else if(name == "Csőrendszer"){
            if(hanyadik == 0){
                qwe = new MyLabel("Szélesség",gs.game.getLabelStyle());
                melyik = 2;
                lvl = gs.game.save.getFloat("csovek_szelessege");
                level = "csovek_szelessege";
            }
            else if(hanyadik == 1){
                qwe = new MyLabel("Csövek elrendezése",gs.game.getLabelStyle());
                melyik = 2;
                lvl = gs.game.save.getFloat("csohalozat_elrendezese");
                level = "csohalozat_elrendezese";
            }
            else if(hanyadik == 2){
                qwe = new MyLabel("Türöképesség",gs.game.getLabelStyle());
                melyik = 3;
                lvl = Math.round(gs.game.save.getFloat("turokepesseg_csovek"));
                level = "turokepesseg_csovek";
            }
            else {
                qwe = new MyLabel("ÚJ CSÖVEK",gs.game.getLabelStyle());
                melyik = 4;
                lvl = (9*(gs.game.save.getFloat("csovek_lvl")+1))-(gs.game.save.getFloat("csovek_szelessege") + gs.game.save.getFloat("csohalozat_elrendezese") + Math.round(gs.game.save.getFloat("turokepesseg_csovek")));
                level = "csovek_lvl";
                mennyikene = 9*(gs.game.save.getFloat("csovek_lvl")+1);
            }
        }
        else if(name == "Munkások"){
            if(hanyadik == 0){
                qwe = new MyLabel("Munkaerö",gs.game.getLabelStyle());
                melyik = 0;
                lvl = gs.game.save.getFloat("munkaero");
                level = "munkaero";
            }
            else if(hanyadik == 1){
                qwe = new MyLabel("Szorgalom",gs.game.getLabelStyle());
                melyik = 1;
                lvl = gs.game.save.getFloat("szorgalom");
                level = "szorgalom";
            }
            else if(hanyadik == 2){
                qwe = new MyLabel("Odafigyelés",gs.game.getLabelStyle());
                melyik = 2;
                lvl = Math.round(gs.game.save.getFloat("odafigyeles"));
                level = "odafigyeles";
            }
            else if(hanyadik == 3){
                qwe = new MyLabel("Adócsalás",gs.game.getLabelStyle());
                melyik = 0;
                lvl = Math.round(gs.game.save.getFloat("adocsalas"));
                level = "adocsalas";
            }
            else if(hanyadik == 4){
                qwe = new MyLabel("Türöképesség",gs.game.getLabelStyle());
                melyik = 3;
                lvl = Math.round(gs.game.save.getFloat("turokepesseg_munkasok"));
                level = "turokepesseg_munkasok";
            }
            else {
                qwe = new MyLabel("ÚJ MUNKÁSOK",gs.game.getLabelStyle());
                melyik = 4;
                lvl = (15*(gs.game.save.getFloat("munkasok_lvl")+1))-(gs.game.save.getFloat("munkaero") + gs.game.save.getFloat("szorgalom") + gs.game.save.getFloat("odafigyeles") + gs.game.save.getFloat("adocsalas") + Math.round(gs.game.save.getFloat("turokepesseg_munkasok")));
                level = "munkasok_lvl";
                mennyikene = 15*(gs.game.save.getFloat("munkasok_lvl")+1);
            }
        }
        else{
            if(hanyadik == 0){
                qwe = new MyLabel("Magasság",gs.game.getLabelStyle());
                melyik = 3;
                lvl = gs.game.save.getFloat("magassag");
                level = "magassag";
            }
            else if(hanyadik == 1){
                qwe = new MyLabel("Vastagság",gs.game.getLabelStyle());
                melyik = 3;
                lvl = gs.game.save.getFloat("vastagsag");
                level = "vastagsag";
            }
            else if(hanyadik == 2){
                qwe = new MyLabel("Türöképesség",gs.game.getLabelStyle());
                melyik = 3;
                lvl = Math.round(gs.game.save.getFloat("turokepesseg_gatfal"));
                level = "turokepesseg_gatfal";
            }
            else {
                qwe = new MyLabel("ÚJ GÁTFAL",gs.game.getLabelStyle());
                melyik = 4;
                lvl = (9*(gs.game.save.getFloat("gatfal_lvl")+1))-(gs.game.save.getFloat("magassag") + gs.game.save.getFloat("vastagsag") + Math.round(gs.game.save.getFloat("turokepesseg_gatfal")));
                level = "gatfal_lvl";
                mennyikene = 9*(gs.game.save.getFloat("gatfal_lvl")+1);
            }
        }

        qwe.setPosition(upgrd.getX()+upgrd.getWidth()/12,upgrd.getY()+upgrd.getHeight()/2.2f);
        qwe.setFontScale(0.7f);
        gs.addActor(qwe);

        if(melyik == 0){
            icon = new OneSpriteStaticActor(Assets.manager.get(Assets.PENZ_PER));
            icon.setSize(upgrd.getHeight()/3,upgrd.getHeight()/3);
            icon.setPosition(upgrd.getX()+upgrd.getHeight()/5,upgrd.getY()+upgrd.getHeight()/10);
            gs.addActor(icon);

             plus = new MyLabel("+Pénz szerzés"+"   Level: "+Math.round(lvl),gs.game.getLabelStyle());
            plus.setPosition(upgrd.getX()+upgrd.getWidth()/7,upgrd.getY()+upgrd.getHeight()/50);
            plus.setFontScale(0.3f);
            gs.addActor(plus);
        }
        else if(melyik == 1){
             icon = new OneSpriteStaticActor(Assets.manager.get(Assets.ARAM));
            icon.setSize(upgrd.getHeight()/3,upgrd.getHeight()/3);
            icon.setPosition(upgrd.getX()+upgrd.getHeight()/5,upgrd.getY()+upgrd.getHeight()/10);
            gs.addActor(icon);

             plus = new MyLabel("+Áram termelés"+"   Level: "+Math.round(lvl),gs.game.getLabelStyle());
            plus.setPosition(upgrd.getX()+upgrd.getWidth()/7,upgrd.getY()+upgrd.getHeight()/50);
            plus.setFontScale(0.3f);
            gs.addActor(plus);
        }
        else if(melyik == 2){
             icon = new OneSpriteStaticActor(Assets.manager.get(Assets.VESZT));
            icon.setSize(upgrd.getHeight()/3,upgrd.getHeight()/3);
            icon.setPosition(upgrd.getX()+upgrd.getHeight()/5,upgrd.getY()+upgrd.getHeight()/10);
            gs.addActor(icon);

             plus = new MyLabel("-Kevesebb áram veszteség"+"   Level: "+Math.round(lvl),gs.game.getLabelStyle());
            plus.setPosition(upgrd.getX()+upgrd.getWidth()/7,upgrd.getY()+upgrd.getHeight()/50);
            plus.setFontScale(0.3f);
            gs.addActor(plus);
        }
        else if(melyik == 3){
             icon = new OneSpriteStaticActor(Assets.manager.get(Assets.SHIELD));
            icon.setSize(upgrd.getHeight()/3,upgrd.getHeight()/3);
            icon.setPosition(upgrd.getX()+upgrd.getHeight()/5,upgrd.getY()+upgrd.getHeight()/10);
            gs.addActor(icon);

             plus = new MyLabel("-Lassabb élet vesztés"+"   Level: "+Math.round(lvl),gs.game.getLabelStyle());
            plus.setPosition(upgrd.getX()+upgrd.getWidth()/7,upgrd.getY()+upgrd.getHeight()/50);
            plus.setFontScale(0.3f);
            gs.addActor(plus);
        }
        else if(melyik == 4){
             icon = new OneSpriteStaticActor(Assets.manager.get(Assets.NEW));
            icon.setSize(upgrd.getHeight()/3,upgrd.getHeight()/3);
            icon.setPosition(upgrd.getX()+upgrd.getHeight()/5,upgrd.getY()+upgrd.getHeight()/10);
            gs.addActor(icon);

            if(lvl <= 0 )plus = new MyLabel("Már fejleszthető",gs.game.getLabelStyle());
            else plus = new MyLabel("Szükséges hozzá még "+Math.round(lvl)+" fejlesztés",gs.game.getLabelStyle());
            plus.setPosition(upgrd.getX()+upgrd.getWidth()/7,upgrd.getY()+upgrd.getHeight()/50);
            plus.setFontScale(0.3f);
            gs.addActor(plus);
        }

        if(melyik ==4){ar = new MyLabel(500+"",gs.game.getLabelStyle()); levelup = 2;}
        else if (melyik == 3){ar = new MyLabel(Math.round ((lvl+1)*25)+"",gs.game.getLabelStyle()); levelup = 1;}
        else {ar = new MyLabel(Math.round ((lvl+1)*25)+"",gs.game.getLabelStyle()); levelup = 0;}
        ar.setPosition(upgrd.getX()+upgrd.getWidth()-upgrd.getWidth()/5.5f,upgrd.getY()+upgrd.getHeight()/2.5f);
        ar.setFontScale(0.6f);
        gs.addActor(ar);

        coin = new OneSpriteStaticActor(Assets.manager.get(Assets.PENZ));
        coin.setSize(upgrd.getHeight()/3,upgrd.getHeight()/3);
        coin.setPosition(upgrd.getX()+upgrd.getWidth()-upgrd.getWidth()/5.5f,upgrd.getY()+upgrd.getHeight()/4.5f);
        gs.addActor(coin);

        front = new OneSpriteStaticActor(Assets.manager.get(Assets.CLICKABLE));
        front.setWidth(gs.getViewport().getWorldWidth()/1.2f);
        front.setHeight(upgrd.getWidth()/4.31f);
        front.setPosition(gs.getViewport().getWorldWidth()/2-upgrd.getWidth()/2,upgrd.getHeight()*hanyadik+gs.getViewport().getWorldHeight()/20);
        front.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                gs.vasarlas(hanyadik);
            }
        });
        gs.addActor(front);
    }

    public void destroy(){
        upgrd.remove();
         coin.remove();
         icon.remove();
         front.remove();
         qwe.remove();
         ar.remove();
         plus.remove();
    }


}
