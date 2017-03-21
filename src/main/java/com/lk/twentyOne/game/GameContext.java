package com.lk.twentyOne.game;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.lk.twentyOne.util.StringUtil;

/**
 * 游戏环境，所有进行中的游戏对象都保存在这里
 * @author lk
 *
 */
public class GameContext {
	
	private static ScheduledExecutorService service;
	private static long GAME_TIMEOUT = 5 * 60 * 1000;
	private static long CLEAN_INTERVAL = 10;

	private static Map<String, Game> map = new HashMap<>();
	
	public static Game getGame(String key) {
		return map.get(key);
	}
	
	public static String newGame(Game game) {
		String key = StringUtil.getUUID();
		map.put(key, game);
		return key;
	}
	
	/**
	 * 清理超时的游戏对象
	 */
	public static void clean() {
		
		long nowTime = new Date().getTime();
		Iterator<Entry<String, Game>> iterator = map.entrySet().iterator();
		
		while (iterator.hasNext()) {
			Entry<String, Game> java = iterator.next();
			if (java.getValue().getUpdateDate().getTime() - nowTime > GAME_TIMEOUT) {
				iterator.remove();
			}
		}
	}
	
	public static void runCleanSchedule() {
		service = Executors.newSingleThreadScheduledExecutor();
		
		service.scheduleAtFixedRate(() -> clean(), CLEAN_INTERVAL, CLEAN_INTERVAL, TimeUnit.MINUTES);
	}
	
	public static void stopCleanSchedule() {
		service.shutdown();
	}
	
}
