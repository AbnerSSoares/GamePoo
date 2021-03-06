package unb.cic.poo.game2d.fases;

import java.util.LinkedList;

import unb.cic.poo.game2d.GameManager;
import unb.cic.poo.game2d.PlayerStatistics;
import unb.cic.poo.game2d.waves.Wave;

public class Fase{
	protected LinkedList<Wave> waves;
	protected boolean faseFinished;
	protected FaseHandler handler;
	protected int faseScore;
	
	public Fase(){
		this.waves = new LinkedList<Wave>();
		faseFinished = false;
	}

	public LinkedList<Wave> getWaves() {
		return waves;
	}

	public void setWaves(LinkedList<Wave> waves) {
		this.waves = waves;
	}
	
	public Wave getCurrentWave(){
		return waves.isEmpty() ? null : waves.getFirst();
	}
	
	public Wave nextWave(){
		waves.pop().onWaveFinish();
		return waves.isEmpty() ? null : waves.getFirst();
	}

	public void setFase() {
		this.waves.get(0).setWave();
	}

	public boolean isFaseFinished() {
		return faseFinished;
	}

	public void setFaseFinished(boolean faseFinished) {
		this.faseFinished = faseFinished;
	}
	
	public void start(){
		waves.getFirst().setWave();
		handler = new FaseHandler(this);
		GameManager.getInstance().getGameScene().registerUpdateHandler(handler);
	}

	/*Esse método é chamado toda vez que a fase é finalizada.*/
	public void onFaseFinished() {
		
		setFaseFinished(true);
	}

	/*Esse método é chamado antes de uma fase iniciar.*/
	public void onFaseStart() {
		
	}

	public int getFaseScore() {
		PlayerStatistics statistics = GameManager.getInstance().getPlayer().getStatistics();
		return faseScore-(10*statistics.getAmountShoot() + 15*statistics.getDamageTaken());
	}

	public void setFaseScore(int faseScore) {
		this.faseScore = faseScore;
	}
	
	public void incrementFaseScore(int score){
		this.faseScore += score;
	}
}
