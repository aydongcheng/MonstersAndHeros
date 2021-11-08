# CS611-Legends

Name
-------------------------------------------------------------------------------------------------
--Zhicheng Dong--
--U63145812--


Files
-------------------------------------------------------------------------------------------------
<Armor.java file> - <the entity of armor
<ArmorCreator.java file> - <the creator of armor
<Board.java file> - <the super class of entity board
<Cell.java file> - <the super class of all cell in the map
<CellCreator.java file> - <the interface of factory pattern to create cell of board
<Characters.java file> - <the super class of characters in the game 
<CommenCell.java file> - <the entity of commom cell
<Displayer.java file> - <the tool class to display infos
<Dragon.java file> - <the entity of monster dragon
<Exoskeleton.java file> - <the entity of monster Exoskeleton
<Fightable.java file> - <the ability of fight with others
<FightManager.java file> - <the manager to manage the fight of heroes and monsters
<FileReader.java file> - <the tool to read the file
<FireSpell.java file> - <the entity of fire spell
<Hero.java file> - <the entity of all kinds of heroes
<IceSpell.java file> - <the entity of ice spell
<Inventory.java file> - <the entity of inventory
<LevelUp.java file> - <the ability to level up
<LightningSpell.java file> - <the entity of lightning spell
<MAHBoard.java file> - <the entity of map
<MAHGame.java file> - <the entity of game monster and hero
<Main.java file> - <main method to start the game
<Market.java file> - <the entity of market
<MarketCell.java file> - <the entity of market cell
<Merchandise.java file> - <the entity of merchandise
<createMercandise.java file> - <the creator of merchandise
<Monster.java file> - <the entity of monster
<MonsterCreator.java file> - <the creator of monster
<NonAccessibleCell.java file> - <the entity of inaccessible cell
<Paladin.java file> - <the entity of paladin
<Potion.java file> - <the entity of potion
<PotionCreator.java file> - <the creator of potion
<ProbabilityCellCreator.java file> - <create different cells with probability
<ProbabilityMAHCellCreator.java file> - <the game monster and hero 's map's cell creator
<RandomMonsterCreator.java file> - <random choose a kind of monster and create
<Sorcerer.java file> - <the entity of sorcerer
<Spell.java file> - <the super class of all kinds of spell
<SpellCreator.java file> - <create certain type of spell
<Spirits.java file> - <the entity of spirits
<Team.java file> - <the entity of team
<Warrior.java file> - <the entity of warrior
<WeanponCreator.java file> - <the creator of weapons
<Weapon.java file> - <the entity of weapon

Bonus:
-------------------------------------------------------------------------------------------------
1.use factory pattern to create heroes/monsters/equipments
2.use decorate pattern to implement the heroes' favored skills get an extra 5% increase
3.the map of the game is scalable
4.all setting of item is loaded from files
5.create a independent class to display complex features

Instructions 
-------------------------------------------------------------------------------------------------
1.monsters also could upgrade to meet the level demand of fighting.
2.hero will fight against monsters until hero is faint in one fighting, then next hero begin to fight against monsters.

Notes:
-------------------------------------------------------------------------------------------------
1. Files to be parsed should be stored in ConfigFiles, for parser class to read class
2. Bonus Done
3. Things instructions to note


How to run:
-------------------------------------------------------------------------------------------------
1. Navigate to the directory '/src' after downloading the project
2. Run the following instructions on command line:
	javac *.java
	java Main
