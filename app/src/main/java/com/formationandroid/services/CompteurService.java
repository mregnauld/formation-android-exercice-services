package com.formationandroid.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import androidx.annotation.Nullable;


public class CompteurService extends Service
{
	
	// Binder :
	private IBinder binder = new MonBinder();
	
	// Compteur :
	private int compteur = 0;
	
	
	@Override
	public void onCreate()
	{
		super.onCreate();
	}
	
	@Nullable
	@Override
	public IBinder onBind(Intent intent)
	{
		return binder;
	}
	
	/**
	 * Getter compteur.
	 * @return compteur
	 */
	public int getCompteur()
	{
		return compteur;
	}
	
	/**
	 * Getter compteur incrémenté.
	 * @return compteur
	 */
	public int getCompteurIncremente()
	{
		compteur++;
		return compteur;
	}
	
	/**
	 * Classe binder.
	 */
	public class MonBinder extends Binder
	{
		/**
		 * Getter service.
		 * @return CompteurService
		 */
		public CompteurService getService()
		{
			return CompteurService.this;
		}
	}
	
}
