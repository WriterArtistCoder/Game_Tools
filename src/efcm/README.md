# Escape from Canamexico
*This README only applies to the `efcm` package and its contents. The rest does not have a README, and in fact has little documentation at all, at the time of writing.*
**Escape from Canamexico** (**EFCM**) is a pixel art prison escape adventure video game set in 2040. <span style="color:#ff4d59;">Canada</span>, <span style="color:#5480f7;">the United States</span>, and <span style="color:#45ad49;">Mexico</span> united to form **<span style="color:#ff4d59;">Can</span><span style="color:#5480f7;">am</span><span style="color:#45ad49;">exico</span>** in 2025, officially the **North American Union** (**NAU**).

Little foresight and planning left the first NAU a mess, but a dictator rose from the chaos to unite the countries once again into a second NAU which was ruled with an iron fist.

Our hero, **Arlo De Libre**, is a former revolutionary who was captured and imprisoned by the NAU secret police on July 4, 2040. He must escape a series of increasingly secure prisons across the continent to win his freedom...

*The game EFCM is developed by @WriterArtistCoder on Github.*

## Design

### Game engine
EFCM does not currently run on the *Game_Tools* game engine (`efcm.game_engine`). I've made my own and I plan to merge the two at some point in the future.

`efcm.game_engine.Runner` has a loop, where for each frame, it requests the `Scene`s and `Sprite`s to complete all their tasks and render themselves for that frame. However, some tasks (e.g. walking) are spread out over several frames. To solve this, I've made a task engine that spreads out tasks over multiple frames.

### Task engine
The task engine (`efcm.task_engine`) runs on `SlowTask`s, which are essentially lists of parts of tasks and extend `java.util.concurrent.ConcurrentLinkedQueue<Runnable>`. Each part of the task is a `Runnable`.
