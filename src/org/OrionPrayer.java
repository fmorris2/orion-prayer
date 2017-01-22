package org;

import java.util.Map;

import org.data.Bones;
import org.worker.OPWorkerManager;

import viking.framework.goal.Goal;
import viking.framework.goal.GoalList;
import viking.framework.item_management.IMEntry;
import viking.framework.item_management.ItemManagement;
import viking.framework.mission.CapitalMission;
import viking.framework.mission.Mission;
import viking.framework.script.VikingScript;

public class OrionPrayer extends Mission implements ItemManagement, CapitalMission
{	
	private static final int BONE_AMT = 300;
	
	public final OPWorkerManager MANAGER;
	
	public Bones bone;
	
	public OrionPrayer(VikingScript script, Bones bone, Goal... goals)
	{
		super(script);
		MANAGER = new OPWorkerManager(this);
		this.bone = bone;
		this.goals = new GoalList(goals);
		
	}

	@Override
	public boolean canEnd()
	{
		return goals.hasReachedGoals();
	}

	@Override
	public String getMissionName()
	{
		return "Orion Prayer";
	}

	@Override
	public String getCurrentTaskName()
	{
		return MANAGER.getCurrent() == null ? "Starting up..." : MANAGER.getCurrent().toString();
	}

	@Override
	public String getEndMessage()
	{
		return "Orion Prayer has ended";
	}

	@Override
	public GoalList getGoals()
	{
		return null;
	}

	@Override
	public String[] getMissionPaint()
	{
		return null;
	}

	@Override
	public int execute()
	{
		return 600;
	}

	@Override
	public void onMissionStart()
	{
	}

	@Override
	public void resetPaint()
	{
	}

	@Override
	public IMEntry[] itemsToBuy()
	{
		return new IMEntry[]{new IMEntry(this, bone.ID, BONE_AMT, bone.SEARCH_TERM)};
	}

	@Override
	public int[] itemsToSell()
	{
		return ItemManagement.ORION_SELL_ITEMS;
	}

	@Override
	public boolean needsCapital()
	{
		Map<Integer, Integer> bankCache = script.BANK_CACHE.get();
		return !bankCache.isEmpty() && !bankCache.containsKey(bone.ID) && !inventory.contains(bone.ID, bone.ID + 1);
	}

}
