package org.worker.impl;

import org.OrionPrayer;
import org.worker.OPWorker;

import viking.api.Timing;

public class OP_WithdrawBones extends OPWorker
{

	public OP_WithdrawBones(OrionPrayer mission)
	{
		super(mission);
	}

	@Override
	public void work()
	{
		if(grandExchange.isOpen())
			grandExchange.close();
		else if(!bank.isOpen() && bankUtils.open())
			Timing.waitCondition(() -> bank.isOpen(), 3500);
		else if(!inventory.onlyContains(mission.bone.ID))
			bank.depositAllExcept(mission.bone.ID);
		else
			bank.withdrawAll(mission.bone.ID);
	}

}
