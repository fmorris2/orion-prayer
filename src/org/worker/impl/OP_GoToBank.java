package org.worker.impl;

import org.OrionPrayer;
import org.worker.OPWorker;

public class OP_GoToBank extends OPWorker
{

	public OP_GoToBank(OrionPrayer mission)
	{
		super(mission);
	}

	@Override
	public void work()
	{
		script.log(this, false, "Going to closest bank");
		walking.webWalk(bankUtils.getAllBanks(false, false));
	}

}
