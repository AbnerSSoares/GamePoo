package unb.cic.poo.game2d.waves;

import java.util.ArrayList;

import unb.cic.poo.game2d.enemies.*;
import unb.cic.poo.game2d.items.FlameThrowerGen;
import unb.cic.poo.game2d.GameActivity;
import unb.cic.poo.game2d.waves.Wave;

public class WaveInicial extends Wave {
	
	/*Wave de CommonEnemy*/
	public WaveInicial(){
		super();
		this.enemies = new ArrayList<Enemy>();
		this.enemies.add(new CommonEnemy(GameActivity.CAMERA_WIDTH, (float) (GameActivity.CAMERA_HEIGHT*0.1)));
		this.enemies.add(new CommonEnemy(GameActivity.CAMERA_WIDTH, (float) (GameActivity.CAMERA_HEIGHT*0.3)));
		this.enemies.add(new CommonEnemy(GameActivity.CAMERA_WIDTH, (float) (GameActivity.CAMERA_HEIGHT*0.5)));
		this.enemies.add(new CommonEnemy(GameActivity.CAMERA_WIDTH, (float) (GameActivity.CAMERA_HEIGHT*0.7)));
		this.enemies.add(new CommonEnemy(GameActivity.CAMERA_WIDTH, (float) (GameActivity.CAMERA_HEIGHT*0.9)));
		this.enemies.add(new CommonEnemy(GameActivity.CAMERA_WIDTH+200, (float) (GameActivity.CAMERA_HEIGHT*0.2)));
		this.enemies.add(new CommonEnemy(GameActivity.CAMERA_WIDTH+200, (float) (GameActivity.CAMERA_HEIGHT*0.4)));
		this.enemies.add(new CommonEnemy(GameActivity.CAMERA_WIDTH+200, (float) (GameActivity.CAMERA_HEIGHT*0.6)));
		this.enemies.add(new CommonEnemy(GameActivity.CAMERA_WIDTH+200, (float) (GameActivity.CAMERA_HEIGHT*0.8)));
		this.enemies.add(new CommonEnemy(GameActivity.CAMERA_WIDTH+400, (float) (GameActivity.CAMERA_HEIGHT*0.1)));
		this.enemies.add(new CommonEnemy(GameActivity.CAMERA_WIDTH+400, (float) (GameActivity.CAMERA_HEIGHT*0.3)));
		this.enemies.add(new CommonEnemy(GameActivity.CAMERA_WIDTH+400, (float) (GameActivity.CAMERA_HEIGHT*0.5)));
		this.enemies.add(new CommonEnemy(GameActivity.CAMERA_WIDTH+400, (float) (GameActivity.CAMERA_HEIGHT*0.7)));
		this.enemies.add(new CommonEnemy(GameActivity.CAMERA_WIDTH+400, (float) (GameActivity.CAMERA_HEIGHT*0.9)));
		
	}
}
