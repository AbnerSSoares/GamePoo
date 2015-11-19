package unb.cic.poo.game2d.fases;

import java.util.LinkedList;

import org.andengine.engine.handler.IUpdateHandler;

import unb.cic.poo.game2d.GameManager;
import unb.cic.poo.game2d.scenes.BaseScene;
import unb.cic.poo.game2d.scenes.GameScene;
import unb.cic.poo.game2d.scenes.SceneManager;

public class FaseManager implements IUpdateHandler{
	private LinkedList<Fase> fases;
	
	public FaseManager(LinkedList<Fase> fases){
		this.fases = fases;
	}
	@Override
	public void onUpdate(float pSecondsElapsed) {
		if(fases.isEmpty()){
			BaseScene aux = SceneManager.gameScene;
			((GameScene) aux).gameOver(true);
		}
		else if(getCurrentFase().isFaseFinished()){
			Fase fase = nextFase();
			if(fase != null){
				fase.onFaseStart();
				fase.start();
			}
		}
		
	}

	private Fase nextFase() {
		fases.pop().onFaseFinished();
		return fases.isEmpty() ? null : fases.getFirst();
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	private Fase getCurrentFase() {
		return fases.isEmpty() ? null : fases.getFirst();
	}
	
	public void start(){
		fases.getFirst().start();
		GameManager.getInstance().getGameScene().registerUpdateHandler(this);
	}
	

	public LinkedList<Fase> getFases() {
		return fases;
	}

	public void setFases(LinkedList<Fase> fases) {
		this.fases = fases;
	}

}
