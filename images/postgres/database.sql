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
    class_id integer

);

CREATE TABLE public.casting (
    class_id integer NOT NULL,
    spell_id integer NOT NULL
);

--
-- Name: Character; Type: TABLE; Schema: public; Owner: postgres
--

ALTER TABLE public.casting OWNER TO postgres;


ALTER TABLE public.character OWNER TO postgres;

--
-- Name: Class; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.class (
    id SERIAL,
    name varchar(64) NOT NULL,
    weapon varchar(64),
    armor varchar(64)
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
-- Name: Spell; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.spell (
    id SERIAL,
    type varchar(64) NOT NULL,
    damage integer NOT NULL,
    cooldown integer NOT NULL,
    range integer NOT NULL
);


ALTER TABLE public.spell OWNER TO postgres;

--
-- Name: Character Character_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.character
    ADD CONSTRAINT "Character_pkey" PRIMARY KEY (id);


--
-- Name: Casting Class_Spell_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.casting
    ADD CONSTRAINT "Class_Spell_pkey" PRIMARY KEY (class_id, spell_id);


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
-- Name: Character Mount_id_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.character
    ADD CONSTRAINT "Mount_id_unique" UNIQUE (mount_id);


--
-- Name: Mount Mount_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mount
    ADD CONSTRAINT "Mount_pkey" PRIMARY KEY (id);


--
-- Name: Spell Spell_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spell
    ADD CONSTRAINT "Spell_pkey" PRIMARY KEY (id);


--
-- Name: Membership Character_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membership
    ADD CONSTRAINT "Character_id_fkey" FOREIGN KEY (character_id) REFERENCES public.character (id) NOT VALID;


--
-- Name: Character Class_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.character
    ADD CONSTRAINT "Class_id_fkey" FOREIGN KEY (class_id) REFERENCES public.class(id) NOT VALID;


--
-- Name: Casting Class_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.casting
    ADD CONSTRAINT "Class_id_fkey" FOREIGN KEY (class_id) REFERENCES public.class(id);


--
-- Name: Membership Guild_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membership
    ADD CONSTRAINT "Guild_id_fkey" FOREIGN KEY (guild_id) REFERENCES public.guild(id) NOT VALID;


--
-- Name: Character Mount_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.character
    ADD CONSTRAINT "Mount_id_fkey" FOREIGN KEY (mount_id) REFERENCES public.mount(id) NOT VALID;


--
-- Name: Casting Spell_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.casting
    ADD CONSTRAINT "Spell_id_fkey" FOREIGN KEY (spell_id) REFERENCES public.spell(id);

-- Fill mount table 

INSERT INTO public.mount(name, speed) VALUES ('Sir Barton', 8);
INSERT INTO public.mount(name, speed) VALUES ('Flame', 5);
INSERT INTO public.mount(name, speed) VALUES ('Fury', 10);
INSERT INTO public.mount(name, speed) VALUES ('Pegasus', 14);
INSERT INTO public.mount(name, speed) VALUES ('Ringo', 7);
INSERT INTO public.mount(name, speed) VALUES ('Rainbow Dash', 8);
INSERT INTO public.mount(name, speed) VALUES ('White Hawk', 9);
INSERT INTO public.mount(name, speed) VALUES ('Rusty Saddle', 12);
INSERT INTO public.mount(name, speed) VALUES ('Artax', 6);
INSERT INTO public.mount(name, speed) VALUES ('Lord Murphy', 11);

-- Fill guild table

INSERT INTO public.guild(name, description) VALUES ('College of Winterhold', 'The College of Winterhold is a guild of mages. It is a faction of magic-users similar to the Mages Guild of Cyrodiil and Morrowind. When the Dragonborn appears, the current Arch-Mage is Savos Aren, with Mirabelle Ervine serving as the Master Wizard. During the faction''s main quest, Tolfdir replaces her as Master Wizard. The College is located in the northern section of the city of Winterhold, in northern Skyrim. Instructors of each magical discipline reside within, offering training and various magical wares to members. ');

INSERT INTO public.guild(name, description) VALUES ('Dark Brotherhood', 'he Dark Brotherhood is an organization of highly trained assassins who carry out assassination contracts. The Dark Brotherhood is called upon by those who wish to utilize their deadly services through a ritual called "The Black Sacrament," although to join the organization, one must be contacted directly. They were once the most feared organization in all of Tamriel, but have lost their reputation over time due to the destruction of multiple sanctuaries across Tamriel. At one point, they were governed by The Five Tenets, which set the ground rules for the Brotherhood, but those tenets have long since been abandoned. The Dark Brotherhood has been operating in Tamriel for many Eras, at one time having many clandestine sanctuaries across the Empire. They revere Sithis, the avatar of entropy and chaos, as well as the Night Mother, who is their spiritual leader.');

INSERT INTO public.guild(name, description) VALUES ('The Companions', 'The Companions are the warriors guild. It serves a similar function to the Fighters Guild chapters of other regions of Tamriel. Eorlund Gray-Mane, a blacksmith in Whiterun, states that they have been leaderless since Ysgramor. He says that an elder known as Kodlak Whitemane acts as the Harbinger (counselor). The fact that they have no official leader is emphasized by their name. If Torvar is asked, "Who''s in charge around here?" before joining, he will reply, "In charge of what? I''m in charge of me, and you''re in charge of you." Jorrvaskr, the mead hall where the Companions live and operate, is the oldest building in Whiterun. ');

INSERT INTO public.guild(name, description) VALUES ('Thieves Guild', 'Based in Skyrim and headquartered in The Ratway beneath the city of Riften, members of the Thieves Guild are renowned for causing trouble in the city and are held largely responsible for the corruption of the city''s markets. Members of the guild specialize in stealing objects of varying value or loaning septims to potential entrepreneurs or to help someone pay off their debts, in hopes of a payback. Most citizens view them unfavorably; Mjoll the Lioness has made it her duty to maintain order in Riften and pledges to dismantle the guild.');

INSERT INTO public.guild(name, description) VALUES ('The Greybeards', 'The Greybeards are an ancient and honored order that dwell in their mountain sanctuary High Hrothgar, which is located on the highest mountain peak in Tamriel, the Throat of the World. As masters of Thu''um, or "the Voice," they live in absolute silence in order to better attune themselves to the voice of the sky. They are a peaceful order, not using their Thu''um to augment their martial skills, but to worship and honor the gods, as the "Way of the Voice" decreed. When the Greybeards speak, storms brew above High Hrothgar, and people are forced to evacuate due to the imminent danger of avalanches. When they even so much as whisper the word "Dovahkiin," it rumbles through the world, and the mountains shake. Such is their power, the last time that they spoke was when they announced the greatness of Tiber Septim.');

-- Fill class table

INSERT INTO public.class(name, weapon, armor)	VALUES ('Barbarian', 'Axe', 'Light');
INSERT INTO public.class(name, weapon, armor)	VALUES ('Bard', 'Violin', 'Medium');
INSERT INTO public.class(name, weapon, armor)	VALUES ('Cleric', 'Mace', 'Light');
INSERT INTO public.class(name, weapon, armor)	VALUES ('Druid', 'Staff', 'Medium');
INSERT INTO public.class(name, weapon, armor)	VALUES ('Fighter', 'Hammer', 'Heavy');
INSERT INTO public.class(name, weapon, armor)	VALUES ('Monk', 'Fists', 'Medium');
INSERT INTO public.class(name, weapon, armor)	VALUES ('Paladin', 'Greatsword', 'Heavy');
INSERT INTO public.class(name, weapon, armor)	VALUES ('Ranger', 'Bow', 'Medium');
INSERT INTO public.class(name, weapon, armor)	VALUES ('Rogue', 'Dagger', 'Medium');
INSERT INTO public.class(name, weapon, armor)	VALUES ('Sorcerer', 'Katana', 'Light');
INSERT INTO public.class(name, weapon, armor)	VALUES ('Warlock', 'Whips', 'Light');
INSERT INTO public.class(name, weapon, armor)	VALUES ('Wizard', 'Catalyst', 'Light');
