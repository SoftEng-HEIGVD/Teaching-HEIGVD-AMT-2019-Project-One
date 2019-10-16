CREATE TABLE public."Casting" (
    class_id integer NOT NULL,
    spell_id integer NOT NULL
);

ALTER TABLE public."Casting" OWNER TO postgres;

--
-- Name: Character; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Character" (
    stamina integer,
    name varchar(64) NOT NULL,
    level integer NOT NULL,
    id SERIAL NOT NULL,
    health integer,
    mana integer,
    mount_id integer,
    class_id integer
);


ALTER TABLE public."Character" OWNER TO postgres;

--
-- Name: Class; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Class" (
    id SERIAL,
    name varchar(64) NOT NULL,
    weapon varchar(64),
    armor varchar(64)
);


ALTER TABLE public."Class" OWNER TO postgres;

--
-- Name: Guild; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Guild" (
    id SERIAL,
    name varchar(64) NOT NULL,
    description varchar(1024)[]
);


ALTER TABLE public."Guild" OWNER TO postgres;

--
-- Name: Membership; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Membership" (
    character_id integer NOT NULL,
    guild_id integer NOT NULL,
    rank varchar(64)
);


ALTER TABLE public."Membership" OWNER TO postgres;

--
-- Name: Mount; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Mount" (
    id SERIAL,
    name varchar(64) NOT NULL,
    speed integer
);


ALTER TABLE public."Mount" OWNER TO postgres;

--
-- Name: Spell; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Spell" (
    id SERIAL,
    type varchar(64),
    damage integer,
    cooldown integer,
    range integer
);


ALTER TABLE public."Spell" OWNER TO postgres;

--
-- Name: Character Character_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Character"
    ADD CONSTRAINT "Character_pkey" PRIMARY KEY (id);


--
-- Name: Casting Class_Spell_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Casting"
    ADD CONSTRAINT "Class_Spell_pkey" PRIMARY KEY (class_id, spell_id);


--
-- Name: Class Class_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Class"
    ADD CONSTRAINT "Class_pkey" PRIMARY KEY (id);


--
-- Name: Guild Guild_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Guild"
    ADD CONSTRAINT "Guild_pkey" PRIMARY KEY (id);


--
-- Name: Membership Membership_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Membership"
    ADD CONSTRAINT "Membership_pkey" PRIMARY KEY (character_id, guild_id);


--
-- Name: Character Mount_id_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Character"
    ADD CONSTRAINT "Mount_id_unique" UNIQUE (mount_id);


--
-- Name: Mount Mount_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Mount"
    ADD CONSTRAINT "Mount_pkey" PRIMARY KEY (id);


--
-- Name: Spell Spell_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Spell"
    ADD CONSTRAINT "Spell_pkey" PRIMARY KEY (id);


--
-- Name: Membership Character_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Membership"
    ADD CONSTRAINT "Character_id_fkey" FOREIGN KEY (character_id) REFERENCES public."Character"(id) NOT VALID;


--
-- Name: Character Class_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Character"
    ADD CONSTRAINT "Class_id_fkey" FOREIGN KEY (class_id) REFERENCES public."Class"(id) NOT VALID;


--
-- Name: Casting Class_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Casting"
    ADD CONSTRAINT "Class_id_fkey" FOREIGN KEY (class_id) REFERENCES public."Class"(id);


--
-- Name: Membership Guild_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Membership"
    ADD CONSTRAINT "Guild_id_fkey" FOREIGN KEY (guild_id) REFERENCES public."Guild"(id) NOT VALID;


--
-- Name: Character Mount_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Character"
    ADD CONSTRAINT "Mount_id_fkey" FOREIGN KEY (mount_id) REFERENCES public."Mount"(id) NOT VALID;


--
-- Name: Casting Spell_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Casting"
    ADD CONSTRAINT "Spell_id_fkey" FOREIGN KEY (spell_id) REFERENCES public."Spell"(id);


