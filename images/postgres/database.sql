CREATE DATABASE amt
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

\connect amt

CREATE TABLE public.character (
    stamina integer NOT NULL DEFAULT 50 ,
    name varchar(64) NOT NULL UNIQUE ,
    level integer NOT NULL DEFAULT 1,
    id SERIAL NOT NULL,
    health integer NOT NULL DEFAULT 50,
    mana integer NOT NULL DEFAULT 50,
    password varchar(64) NOT NULL,
    mount_id integer,
    class_id integer,
    isadmin boolean NOT NULL DEFAULT FALSE

);


ALTER TABLE public.character OWNER TO postgres;

--
-- Name: Class; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.class (
    id SERIAL,
    name varchar(64) NOT NULL,
    weapon varchar(64),
    armor varchar(64),
    description varchar(1500)
);


ALTER TABLE public.class OWNER TO postgres;

--
-- Name: Guild; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.guild (
    id SERIAL,
    name varchar(64) NOT NULL,
    description varchar(1024)
);


ALTER TABLE public.guild OWNER TO postgres;

--
-- Name: Membership; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.membership (
    id SERIAL,
    character_id integer NOT NULL,
    guild_id integer NOT NULL,
    rank varchar(64)
);


ALTER TABLE public.membership OWNER TO postgres;

--
-- Name: Mount; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mount (
    id SERIAL,
    name varchar(64) NOT NULL,
    speed integer NOT NULL
);


ALTER TABLE public.mount OWNER TO postgres;


--
-- Name: Character Character_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.character
    ADD CONSTRAINT "Character_pkey" PRIMARY KEY (id);



--
-- Name: Class Class_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.class
    ADD CONSTRAINT "Class_pkey" PRIMARY KEY (id);


--
-- Name: Guild Guild_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.guild
    ADD CONSTRAINT "Guild_pkey" PRIMARY KEY (id);


--
-- Name: Membership Membership_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membership
    ADD CONSTRAINT "Membership_pkey" PRIMARY KEY (character_id, guild_id);


--
-- Name: Mount Mount_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mount
    ADD CONSTRAINT "Mount_pkey" PRIMARY KEY (id);


--
-- Name: Membership Character_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membership
    ADD CONSTRAINT "Character_id_fkey" FOREIGN KEY (character_id) REFERENCES public.character (id)  ON DELETE CASCADE NOT VALID;


--
-- Name: Character Class_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.character
    ADD CONSTRAINT "Class_id_fkey" FOREIGN KEY (class_id) REFERENCES public.class(id) NOT VALID ON DELETE SET NULL;


--
-- Name: Membership Guild_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membership
    ADD CONSTRAINT "Guild_id_fkey" FOREIGN KEY (guild_id) REFERENCES public.guild(id) ON DELETE CASCADE NOT VALID;


--
-- Name: Character Mount_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.character
    ADD CONSTRAINT "Mount_id_fkey" FOREIGN KEY (mount_id) REFERENCES public.mount(id) ON DELETE SET NULL NOT VALID;


-- Fill mount table 

INSERT INTO public.mount(name, speed) VALUES ('Demona', 5);
INSERT INTO public.mount(name, speed) VALUES ('Flame', 10);
INSERT INTO public.mount(name, speed) VALUES ('Kitty', 14);
INSERT INTO public.mount(name, speed) VALUES ('Luna', 7);
INSERT INTO public.mount(name, speed) VALUES ('Pegasus', 8);
INSERT INTO public.mount(name, speed) VALUES ('Misty', 9);
INSERT INTO public.mount(name, speed) VALUES ('Pony', 12);
INSERT INTO public.mount(name, speed) VALUES ('Rainbow Trash', 2);
INSERT INTO public.mount(name, speed) VALUES ('Uni', 18);
INSERT INTO public.mount(name, speed) VALUES ('Whalee', 11);

-- Fill guild table

INSERT INTO public.guild(name, description) VALUES ('College of Winterhold', 'The College of Winterhold is a guild of mages. It is a faction of magic-users similar to the Mages Guild of Cyrodiil and Morrowind. When the Dragonborn appears, the current Arch-Mage is Savos Aren, with Mirabelle Ervine serving as the Master Wizard. During the faction''s main quest, Tolfdir replaces her as Master Wizard. The College is located in the northern section of the city of Winterhold, in northern Skyrim. Instructors of each magical discipline reside within, offering training and various magical wares to members. ');

INSERT INTO public.guild(name, description) VALUES ('Dark Brotherhood', 'he Dark Brotherhood is an organization of highly trained assassins who carry out assassination contracts. The Dark Brotherhood is called upon by those who wish to utilize their deadly services through a ritual called "The Black Sacrament," although to join the organization, one must be contacted directly. They were once the most feared organization in all of Tamriel, but have lost their reputation over time due to the destruction of multiple sanctuaries across Tamriel. At one point, they were governed by The Five Tenets, which set the ground rules for the Brotherhood, but those tenets have long since been abandoned. The Dark Brotherhood has been operating in Tamriel for many Eras, at one time having many clandestine sanctuaries across the Empire. They revere Sithis, the avatar of entropy and chaos, as well as the Night Mother, who is their spiritual leader.');

INSERT INTO public.guild(name, description) VALUES ('The Companions', 'The Companions are the warriors guild. It serves a similar function to the Fighters Guild chapters of other regions of Tamriel. Eorlund Gray-Mane, a blacksmith in Whiterun, states that they have been leaderless since Ysgramor. He says that an elder known as Kodlak Whitemane acts as the Harbinger (counselor). The fact that they have no official leader is emphasized by their name. If Torvar is asked, "Who''s in charge around here?" before joining, he will reply, "In charge of what? I''m in charge of me, and you''re in charge of you." Jorrvaskr, the mead hall where the Companions live and operate, is the oldest building in Whiterun. ');

INSERT INTO public.guild(name, description) VALUES ('Thieves Guild', 'Based in Skyrim and headquartered in The Ratway beneath the city of Riften, members of the Thieves Guild are renowned for causing trouble in the city and are held largely responsible for the corruption of the city''s markets. Members of the guild specialize in stealing objects of varying value or loaning septims to potential entrepreneurs or to help someone pay off their debts, in hopes of a payback. Most citizens view them unfavorably; Mjoll the Lioness has made it her duty to maintain order in Riften and pledges to dismantle the guild.');

INSERT INTO public.guild(name, description) VALUES ('The Greybeards', 'The Greybeards are an ancient and honored order that dwell in their mountain sanctuary High Hrothgar, which is located on the highest mountain peak in Tamriel, the Throat of the World. As masters of Thu''um, or "the Voice," they live in absolute silence in order to better attune themselves to the voice of the sky. They are a peaceful order, not using their Thu''um to augment their martial skills, but to worship and honor the gods, as the "Way of the Voice" decreed. When the Greybeards speak, storms brew above High Hrothgar, and people are forced to evacuate due to the imminent danger of avalanches. When they even so much as whisper the word "Dovahkiin," it rumbles through the world, and the mountains shake. Such is their power, the last time that they spoke was when they announced the greatness of Tiber Septim.');

-- Fill class table

INSERT INTO public.class(name, weapon, armor, description) VALUES ('Barbarian', 'Axe', 'Light', 'A tall human tribesman strides through a blizzard, draped in fur and hefting his axe. He laughs as he charges toward the frost giant who dared poach his people’s elk herd. A half-orc snarls at the latest challenger to her authority over their savage tribe, ready to break his neck with her bare hands as she did to the last six rivals. Frothing at the mouth, a dwarf slams his helmet into the face of his drow foe, then turns to drive his armored elbow into the gut of another. These barbarians, different as they might be, are defined by their rage: unbridled, unquenchable, and unthinking fury. More than a mere emotion, their anger is the ferocity of a cornered predator, the unrelenting assault of a storm, the churning turmoil of the sea. For some, their rage springs from a communion with fierce animal spirits. Others draw from a roiling reservoir of anger at a world full of pain. For every barbarian, rage is a power that fuels not just a battle frenzy but also uncanny reflexes, resilience, and feats of strength.');
INSERT INTO public.class(name, weapon, armor, description) VALUES ('Bard', 'Violin', 'Medium', 'Humming as she traces her fingers over an ancient monument in a long-forgotten ruin, a half-elf in rugged leathers finds knowledge springing into her mind, conjured forth by the magic of her song—knowledge of the people who constructed the monument and the mythic saga it depicts. A stern human warrior bangs his sword rhythmically against his scale mail, setting the tempo for his war chant and exhorting his companions to bravery and heroism. The magic of his song fortifies and emboldens them. Laughing as she tunes her cittern, a gnome weaves her subtle magic over the assembled nobles, ensuring that her companions’ words will be well received. Whether scholar, skald, or scoundrel, a bard weaves magic through words and music to inspire allies, demoralize foes, manipulate minds, create illusions, and even heal wounds.');
INSERT INTO public.class(name, weapon, armor, description) VALUES ('Cleric', 'Mace', 'Light', 'Arms and eyes upraised toward the sun and a prayer on his lips, an elf begins to glow with an inner light that spills out to heal his battle-worn companions. Chanting a song of glory, a dwarf swings his axe in wide swaths to cut through the ranks of orcs arrayed against him, shouting praise to the gods with every foe’s fall. Calling down a curse upon the forces of undeath, a human lifts her holy symbol as light pours from it to drive back the zombies crowding in on her companions. Clerics are intermediaries between the mortal world and the distant planes of the gods. As varied as the gods they serve, clerics strive to embody the handiwork of their deities. No ordinary priest, a cleric is imbued with divine magic.');
INSERT INTO public.class(name, weapon, armor, description) VALUES ('Druid', 'Staff', 'Medium', 'Holding high a gnarled staff wreathed with holly, an elf summons the fury of the storm and calls down explosive bolts of lightning to smite the torch-carrying orcs who threaten her forest. Crouching out of sight on a high tree branch in the form of a leopard, a human peers out of the jungle at the strange construction of a temple of Evil Elemental Air, keeping a close eye on the cultists’ activities. Swinging a blade formed of pure fire, a half-elf charges into a mass of skeletal soldiers, sundering the unnatural magic that gives the foul creatures the mocking semblance of life. Whether calling on the elemental forces of nature or emulating the creatures of the animal world, druids are an embodiment of nature’s resilience, cunning, and fury. They claim no mastery over nature. Instead, they see themselves as extensions of nature’s indomitable will.');
INSERT INTO public.class(name, weapon, armor, description) VALUES ('Fighter', 'Hammer', 'Heavy', 'A human in clanging plate armor holds her shield before her as she runs toward the massed goblins. An elf behind her, clad in studded leather armor, peppers the goblins with arrows loosed from his exquisite bow. The half-orc nearby shouts orders, helping the two combatants coordinate their assault to the best advantage. A dwarf in chain mail interposes his shield between the ogre’s club and his companion, knocking the deadly blow aside. His companion, a half-elf in scale armor, swings two scimitars in a blinding whirl as she circles the ogre, looking for a blind spot in its defenses. A gladiator fights for sport in an arena, a master with his trident and net, skilled at toppling foes and moving them around for the crowd’s delight—and his own tactical advantage. His opponent’s sword flares with blue light an instant before she sends lightning flashing forth to smite him. All of these heroes are fighters, perhaps the most diverse class of characters in the worlds of Dungeons & Dragons. Questing knights, conquering overlords, royal champions, elite foot soldiers, hardened mercenaries, and bandit kings—as fighters, they all share an unparalleled mastery with weapons and armor, and a thorough knowledge of the skills of combat. And they are well acquainted with death, both meting it out and staring it defiantly in the face.');
INSERT INTO public.class(name, weapon, armor, description) VALUES ('Monk', 'Fists', 'Medium', 'Her fists a blur as they deflect an incoming hail of arrows, a half-elf springs over a barricade and throws herself into the massed ranks of hobgoblins on the other side. She whirls among them, knocking their blows aside and sending them reeling, until at last she stands alone. Taking a deep breath, a human covered in tattoos settles into a battle stance. As the first charging orcs reach him, he exhales and a blast of fire roars from his mouth, engulfing his foes. Moving with the silence of the night, a black-clad halfling steps into a shadow beneath an arch and emerges from another inky shadow on a balcony a stone’s throw away. She slides her blade free of its cloth-wrapped scabbard and peers through the open window at the tyrant prince, so vulnerable in the grip of sleep. Whatever their discipline, monks are united in their ability to magically harness the energy that flows in their bodies. Whether channeled as a striking display of combat prowess or a subtler focus of defensive ability and speed, this energy infuses all that a monk does.');
INSERT INTO public.class(name, weapon, armor, description) VALUES ('Paladin', 'Greatsword', 'Heavy', 'Clad in plate armor that gleams in the sunlight despite the dust and grime of long travel, a human lays down her sword and shield and places her hands on a mortally wounded man. Divine radiance shines from her hands, the man’s wounds knit closed, and his eyes open wide with amazement. A dwarf crouches behind an outcrop, his black cloak making him nearly invisible in the night, and watches an orc war band celebrating its recent victory. Silently, he stalks into their midst and whispers an oath, and two orcs are dead before they even realize he is there. Silver hair shining in a shaft of light that seems to illuminate only him, an elf laughs with exultation. His spear flashes like his eyes as he jabs again and again at a twisted giant, until at last his light overcomes its hideous darkness. Whatever their origin and their mission, paladins are united by their oaths to stand against the forces of evil. Whether sworn before a god’s altar and the witness of a priest, in a sacred glade before nature spirits and fey beings, or in a moment of desperation and grief with the dead as the only witness, a paladin’s oath is a powerful bond. It is a source of power that turns a devout warrior into a blessed champion.');
INSERT INTO public.class(name, weapon, armor, description) VALUES ('Ranger', 'Bow', 'Medium', 'Rough and wild looking, a human stalks alone through the shadows of trees, hunting the orcs he knows are planning a raid on a nearby farm. Clutching a shortsword in each hand, he becomes a whirlwind of steel, cutting down one enemy after another. After tumbling away from a cone of freezing air, an elf finds her feet and draws back her bow to loose an arrow at the white dragon. Shrugging off the wave of fear that emanates from the dragon like the cold of its breath, she sends one arrow after another to find the gaps between the dragon’s thick scales. Holding his hand high, a half-elf whistles to the hawk that circles high above him, calling the bird back to his side. Whispering instructions in Elvish, he points to the owlbear he’s been tracking and sends the hawk to distract the creature while he readies his bow. Far from the bustle of cities and towns, past the hedges that shelter the most distant farms from the terrors of the wild, amid the dense-packed trees of trackless forests and across wide and empty plains, rangers keep their unending watch.');
INSERT INTO public.class(name, weapon, armor, description) VALUES ('Rogue', 'Dagger', 'Medium', 'Signaling for her companions to wait, a halfling creeps forward through the dungeon hall. She presses an ear to the door, then pulls out a set of tools and picks the lock in the blink of an eye. Then she disappears into the shadows as her fighter friend moves forward to kick the door open. A human lurks in the shadows of an alley while his accomplice prepares for her part in the ambush. When their target — a notorious slaver — passes the alleyway, the accomplice cries out, the slaver comes to investigate, and the assassin’s blade cuts his throat before he can make a sound. Suppressing a giggle, a gnome waggles her fingers and magically lifts the key ring from the guard’s belt. In a moment, the keys are in her hand, the cell door is open, and she and her companions are free to make their escape. Rogues rely on skill, stealth, and their foes’ vulnerabilities to get the upper hand in any situation. They have a knack for finding the solution to just about any problem, demonstrating a resourcefulness and versatility that is the cornerstone of any successful adventuring party.');
INSERT INTO public.class(name, weapon, armor, description) VALUES ('Sorcerer', 'Katana', 'Light', 'Golden eyes flashing, a human stretches out her hand and unleashes the dragonfire that burns in her veins. As an inferno rages around her foes, leathery wings spread from her back and she takes to the air. Long hair whipped by a conjured wind, a half-elf spreads his arms wide and throws his head back. Lifting him momentarily off the ground, a wave of magic surges up in him, through him, and out from him in a mighty blast of lightning. Crouching behind a stalagmite, a halfling points a finger at a charging troglodyte. A blast of fire springs from her finger to strike the creature. She ducks back behind the rock formation with a grin, unaware that her wild magic has turned her skin bright blue. Sorcerers carry a magical birthright conferred upon them by an exotic bloodline, some otherworldly influence, or exposure to unknown cosmic forces. One can’t study sorcery as one learns a language, any more than one can learn to live a legendary life. No one chooses sorcery; the power chooses the sorcerer.');
INSERT INTO public.class(name, weapon, armor, description) VALUES ('Warlock', 'Whips', 'Light', 'With a pseudodragon curled on his shoulder, a young elf in golden robes smiles warmly, weaving a magical charm into his honeyed words and bending the palace sentinel to his will. As flames spring to life in her hands, a wizened human whispers the secret name of her demonic patron, infusing her spell with fiendish magic. Shifting his gaze between a battered tome and the odd alignment of the stars overhead, a wild-eyed tiefling chants the mystic ritual that will open a doorway to a distant world. Warlocks are seekers of the knowledge that lies hidden in the fabric of the multiverse. Through pacts made with mysterious beings of supernatural power, warlocks unlock magical effects both subtle and spectacular. Drawing on the ancient knowledge of beings such as fey nobles, demons, devils, hags, and alien entities of the Far Realm, warlocks piece together arcane secrets to bolster their own power.');
INSERT INTO public.class(name, weapon, armor, description) VALUES ('Wizard', 'Catalyst', 'Light', 'Clad in the silver robes that denote her station, an elf closes her eyes to shut out the distractions of the battlefield and begins her quiet chant. Fingers weaving in front of her, she completes her spell and launches a tiny bead of fire toward the enemy ranks, where it erupts into a conflagration that engulfs the soldiers. Checking and rechecking his work, a human scribes an intricate magic circle in chalk on the bare stone floor, then sprinkles powdered iron along every line and graceful curve. When the circle is complete, he drones a long incantation. A hole opens in space inside the circle, bringing a whiff of brimstone from the otherworldly plane beyond. Crouching on the floor in a dungeon intersection, a gnome tosses a handful of small bones inscribed with mystic symbols, muttering a few words of power over them. Closing his eyes to see the visions more clearly, he nods slowly, then opens his eyes and points down the passage to his left. Wizards are supreme magic-users, defined and united as a class by the spells they cast. Drawing on the subtle weave of magic that permeates the cosmos, wizards cast spells of explosive fire, arcing lightning, subtle deception, and brute-force mind control. Their magic conjures monsters from other planes of existence, glimpses the future, or turns slain foes into zombies. Their mightiest spells change one substance into another, call meteors down from the sky, or open portals to other worlds.');

-- Test user

INSERT INTO public."character"(stamina, name, level, id, health, mana, password, mount_id, class_id) VALUES (80, 'test', 100, 1, 80, 80, '$2a$10$PYyJXwPKBOzic3JIHCVd5uNIS5.DplEyWtkDPnhseetf0Sv8LovAC', 1, 1);
INSERT INTO public.membership(character_id, guild_id, rank) VALUES (1, 1, 'Guildmaster');
INSERT INTO public.membership(character_id, guild_id, rank) VALUES (1, 3, 'Initiate');
INSERT INTO public.membership(character_id, guild_id, rank) VALUES (1, 5, 'Warden');

