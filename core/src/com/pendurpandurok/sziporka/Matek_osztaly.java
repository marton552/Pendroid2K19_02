package com.pendurpandurok.sziporka;

import com.pendurpandurok.sziporka.Screens.Menu.MenuStage;

public class Matek_osztaly {

    public float osszeg = 0;

    public Matek_osztaly(MenuStage gs,float penz, float aram, float veszt, float gen_hp, float lapat_hp, float cso_hp, float munkas_hp, float fal_hp){
        if(gen_hp > 75) gen_hp = 1.25f;
        else if(gen_hp > 50) gen_hp = 1f;
        else if(gen_hp > 25) gen_hp = 0.75f;
        else if(gen_hp > 1) gen_hp = 0.25f;
        else gen_hp = 0.05f;

        if(lapat_hp > 75) lapat_hp = 1.25f;
        else if(lapat_hp > 50) lapat_hp = 1f;
        else if(lapat_hp > 25) lapat_hp = 0.75f;
        else if(lapat_hp > 1) lapat_hp = 0.25f;
        else lapat_hp = 0.05f;

        if(cso_hp > 75) cso_hp = 1.25f;
        else if(cso_hp > 50) cso_hp = 1f;
        else if(cso_hp > 25) cso_hp = 0.75f;
        else if(cso_hp > 1) cso_hp = 0.25f;
        else cso_hp = 0.05f;

        if(munkas_hp > 75) munkas_hp = 1.25f;
        else if(munkas_hp > 50) munkas_hp = 1f;
        else if(munkas_hp > 25) munkas_hp = 0.75f;
        else if(munkas_hp > 1) munkas_hp = 0.25f;
        else munkas_hp = 0.05f;

        if(fal_hp > 75) fal_hp = 1.25f;
        else if(fal_hp > 50) fal_hp = 1f;
        else if(fal_hp > 25) fal_hp = 0.75f;
        else if(fal_hp > 1) fal_hp = 0.25f;
        else fal_hp = 0.05f;

        osszeg = penz*aram*veszt*gen_hp*lapat_hp*cso_hp*munkas_hp*fal_hp;

        if(gs.game.save.getFloat("generator_hp") > 0)gs.game.save.putFloat("generator_hp",gs.game.save.getFloat("generator_hp")-(0.5f/(gs.game.save.getFloat("turokepesseg_generator")+1)));
        if(gs.game.save.getFloat("lapat_hp") > 0)gs.game.save.putFloat("lapat_hp",gs.game.save.getFloat("lapat_hp")-(0.5f/(gs.game.save.getFloat("turokepesseg_lapat")+1)));
        if(gs.game.save.getFloat("gatfal_hp") > 0)gs.game.save.putFloat("gatfal_hp",gs.game.save.getFloat("gatfal_hp")-(0.5f/(gs.game.save.getFloat("turokepesseg_gatfal")+1)));
        if(gs.game.save.getFloat("munkasok_hp") > 0)gs.game.save.putFloat("munkasok_hp",gs.game.save.getFloat("munkasok_hp")-(0.5f/(gs.game.save.getFloat("turokepesseg_munkasok")+1)));
        if(gs.game.save.getFloat("csovek_hp") > 0)gs.game.save.putFloat("csovek_hp",gs.game.save.getFloat("csovek_hp")-(0.5f/(gs.game.save.getFloat("turokepesseg_csovek")+1)));

        //gs.game.save.flush();
    }
}
