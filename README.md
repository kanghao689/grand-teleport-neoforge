# Grand Teleport (NeoForge 1.21.1)

Grand Teleport adds a GTA-style cinematic camera transition to Minecraft
teleports.

When a teleport starts, the camera leaves the player, pulls up through several
zoom stages, moves across the world when possible, and then returns to the
player near the destination. The original teleport is still handled by
Minecraft, the server, or the other mod that started it. Grand Teleport adds
the cinematic transition around it.

## About this repository

This is an **unofficial NeoForge port** of the original Grand Teleport mod by
[hookuru_](https://github.com/hookuru/GrandTeleport), which targets the Fabric
loader. It is not affiliated with or endorsed by the original author.

- Original project: https://github.com/hookuru/GrandTeleport
- This port targets: Minecraft 1.21.1, NeoForge 21.1.252, Java 21

## Supported versions

- Minecraft 1.21.1 (NeoForge)

## Main features

- GTA-style pull-out, overhead travel, and pull-in camera transition.
- Configurable zoom-stage camera heights.
- Separate zoom-stage settings for the Overworld, the Nether, and the End.
- Optional player input blocking during the transition.
- Optional cross-dimension camera travel.
- Minecraft sound mode and Grand Teleport custom sound mode.
- Configuration screen (opened with `/gtp config` or `/grandtp config`).
- Client commands using both `/gtp` and `/grandtp`.

## Supported teleport sources

Grand Teleport can react to common teleport commands such as:

- `/tp`
- `/teleport`
- `/minecraft:tp`
- `/minecraft:teleport`
- `/execute ... run tp ...`
- `/execute ... run teleport ...`

Depending on the Minecraft version and installed mods, Grand Teleport also
supports several mod or server-assisted teleport flows, including JourneyMap
teleports, Waystones teleports, Warp Plate teleports, command blocks, and other
player-targeted teleports.

For multiplayer server-side teleport sources, Grand Teleport may also need to
be installed on the server.

## Commands

- `/gtp on` or `/grandtp on` - enable the transition.
- `/gtp off` or `/grandtp off` - disable the transition.
- `/gtp status` or `/grandtp status` - show the current status.
- `/gtp config` or `/grandtp config` - open the configuration screen.
- `/gtp player_freeze on` or `/grandtp player_freeze on` - block movement and
  camera input during the transition.
- `/gtp player_freeze off` or `/grandtp player_freeze off` - allow movement
  during the transition.
- `/gtp player_freeze status` or `/grandtp player_freeze status` - show the
  player-freeze status.

## Recommended companion mods

Grand Teleport feels best when the camera can see distant terrain during the
transition. Voxy and Distant Horizons are recommended if your PC can run them
comfortably.

These mods are optional. Grand Teleport works without them, but the transition
is more impressive when long-distance terrain is visible.

## Build

```sh
./gradlew build
```

Requires Java 21. The mod jar is written to:

- `build/libs/gtalike_teleport-1.21.1-neoforge-1.0.0.jar`

A prebuilt jar is also committed under `dist/` for convenience.

## License

Grand Teleport source code and documentation are licensed under the MIT License,
except where otherwise noted.

Bundled Grand Teleport custom sound effects are not licensed under MIT. They are
edited audio assets created from sounds licensed from ZapSplat under a paid
Premium plan, and are included only for use as part of Grand Teleport.

Do not extract, redistribute, sell, sublicense, or reuse the bundled custom
sound files separately. ZapSplat audio remains subject to the ZapSplat license:
https://www.zapsplat.com/license-type/standard-license/

## Credits

This mod was coded with Codex, and playtesting and supervision were handled by hookuru_.

NeoForge 1.21.1 port by kanghao689, ported with AiCode.
