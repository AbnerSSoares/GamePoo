package unb.cic.poo.game2d.fases;

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.sprite.Sprite;

import unb.cic.poo.game2d.GameManager;
import unb.cic.poo.game2d.ParallaxApplication;
import unb.cic.poo.game2d.ResourceManager;
import unb.cic.poo.game2d.scenes.GameScene;
import unb.cic.poo.game2d.waves.Fase2.*;

public class Fase2 extends Fase{	
		
	public Fase2(){
		this.waves.add(new Wave1());
		this.waves.add(new Wave2());
		this.waves.add(new Wave3());
		this.waves.add(new Wave4());
		this.waves.add(new Wave5());
	}	
	
	@Override
	public void onFaseStart() {
		((GameScene)GameManager.getInstance().getGameScene()).showTransition("Fase 2");
		GameManager.getInstance().getGameScene().registerUpdateHandler(new TimerHandler(3f, new ITimerCallback()
	    {                                    
	        public void onTimePassed(final TimerHandler pTimerHandler)
	        {
	            pTimerHandler.reset();
	            GameManager.getInstance().getGameScene().unregisterUpdateHandler(pTimerHandler);
	            GameManager.getInstance().getFaseManager().getCurrentFase().start();
	    		((GameScene)GameManager.getInstance().getGameScene()).hideTransition();
	        }
	    }));
	}
	
	public void onFaseFinished() {
		
		((GameScene)GameManager.getInstance().getGameScene()).showTransition("Bom Trabalho!");
		GameManager.getInstance().getGameScene().registerUpdateHandler(new TimerHandler(3f, new ITimerCallback()
	    {                                    
	        public void onTimePassed(final TimerHandler pTimerHandler)
	        {
	            pTimerHandler.reset();
	            GameManager.getInstance().getGameScene().unregisterUpdateHandler(pTimerHandler);
	    		setFaseFinished(true);
	    		((GameScene)GameManager.getInstance().getGameScene()).hideTransition();
	        }
	    }));
	}
}
