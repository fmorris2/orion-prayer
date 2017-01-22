package org.worker;

import org.OrionPrayer;

import viking.framework.worker.Worker;

public abstract class OPWorker extends Worker<OrionPrayer>
{

	public OPWorker(OrionPrayer mission)
	{
		super(mission);
	}

	@Override
	public boolean needsRepeat()
	{
		return false;
	}
}
