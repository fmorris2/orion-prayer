package org.worker.impl;

import org.OrionPrayer;
import org.worker.OPWorker;

public class OP_BuryBones extends OPWorker
{

	public OP_BuryBones(OrionPrayer mission)
	{
		super(mission);
	}

	@Override
	public void work()
	{
		if(bank.isOpen())
			bank.close();
		else
		{
			script.log(this, false, "Bury bones");
			
		}
	}

}
