package org.worker;

import org.OrionPrayer;
import org.worker.impl.OP_BuryBones;
import org.worker.impl.OP_GoToBank;
import org.worker.impl.OP_WithdrawBones;

import viking.framework.worker.Worker;
import viking.framework.worker.WorkerManager;

public class OPWorkerManager extends WorkerManager<OrionPrayer>
{
	public final OP_BuryBones BURY;
	public final OP_GoToBank GO_TO_BANK;
	public final OP_WithdrawBones WITHDRAW_BONES;
	
	public OPWorkerManager(OrionPrayer mission)
	{
		super(mission);
		BURY = new OP_BuryBones(mission);
		GO_TO_BANK = new OP_GoToBank(mission);
		WITHDRAW_BONES = new OP_WithdrawBones(mission);
	}

	@Override
	public Worker<OrionPrayer> decide()
	{
		if(!mission.bankUtils.isInBank(false))
			return GO_TO_BANK;
		
		return inventory.isFull() || !inventory.onlyContains(mission.bone.ID) ? WITHDRAW_BONES : BURY;
	}

}
