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
