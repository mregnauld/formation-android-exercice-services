package com.formationandroid.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;


public class CompteurIntentService extends IntentService
{
	
	// Constantes :
	private static final String TAG = CompteurIntentService.class.getSimpleName();
	
	// Compteur :
	private int compteur = 0;
	
	
	/**
	 * Constructeur.
	 */
	public CompteurIntentService()
	{
		super("CompteurIntentService");
	}
	
	@Override
	protected void onHandleIntent(@Nullable Intent intent)
	{
		// attente artificielle de 3 secondes pour simuler un traîtement long :
		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		// incrémentation du compteur et affichage dans les logs :
		compteur++;
		Log.i(TAG, "compteur intent service = " + compteur);
	}
	
}
