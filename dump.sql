PGDMP     +    :    	            z            Waves #   12.9 (Ubuntu 12.9-0ubuntu0.20.04.1) #   12.9 (Ubuntu 12.9-0ubuntu0.20.04.1) =    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    32768    Waves    DATABASE     y   CREATE DATABASE "Waves" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';
    DROP DATABASE "Waves";
                fpw    false            �            1259    49154    amministratore    TABLE     �   CREATE TABLE public.amministratore (
    id integer NOT NULL,
    username character varying(20),
    password character varying(20)
);
 "   DROP TABLE public.amministratore;
       public         heap    fpw    false            �            1259    49152    amministratore_id_seq    SEQUENCE     �   CREATE SEQUENCE public.amministratore_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.amministratore_id_seq;
       public          fpw    false    209            �           0    0    amministratore_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.amministratore_id_seq OWNED BY public.amministratore.id;
          public          fpw    false    208            �            1259    32789    bagnino    TABLE     �   CREATE TABLE public.bagnino (
    id_bagnino integer NOT NULL,
    nome character varying(50),
    cognome character varying(50),
    email character varying(50),
    attestati character varying(250),
    cellulare character(10)
);
    DROP TABLE public.bagnino;
       public         heap    fpw    false            �            1259    32787    bagnino_id_bagnino_seq    SEQUENCE     �   CREATE SEQUENCE public.bagnino_id_bagnino_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.bagnino_id_bagnino_seq;
       public          fpw    false    207            �           0    0    bagnino_id_bagnino_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.bagnino_id_bagnino_seq OWNED BY public.bagnino.id_bagnino;
          public          fpw    false    206            �            1259    81922    fattura    TABLE     �   CREATE TABLE public.fattura (
    id integer NOT NULL,
    prezzo integer,
    data date,
    posti integer,
    id_bagnino integer,
    descrizione character varying(50),
    id_utente integer
);
    DROP TABLE public.fattura;
       public         heap    fpw    false            �            1259    81920    fattura_id_seq    SEQUENCE     �   CREATE SEQUENCE public.fattura_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.fattura_id_seq;
       public          fpw    false    213            �           0    0    fattura_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.fattura_id_seq OWNED BY public.fattura.id;
          public          fpw    false    212            �            1259    98306 	   messaggio    TABLE     �   CREATE TABLE public.messaggio (
    id integer NOT NULL,
    id_user integer,
    destinatario character varying(10),
    letto character varying(2),
    testo character varying(200)
);
    DROP TABLE public.messaggio;
       public         heap    fpw    false            �            1259    98304    messaggio_id_seq    SEQUENCE     �   CREATE SEQUENCE public.messaggio_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.messaggio_id_seq;
       public          fpw    false    215            �           0    0    messaggio_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.messaggio_id_seq OWNED BY public.messaggio.id;
          public          fpw    false    214            �            1259    32781    prenotazione    TABLE     �   CREATE TABLE public.prenotazione (
    id_prenotazione integer NOT NULL,
    data date,
    id_bagnino bigint,
    posti_mattina integer,
    posti_sera integer
);
     DROP TABLE public.prenotazione;
       public         heap    fpw    false            �            1259    32779     prenotazione_id_prenotazione_seq    SEQUENCE     �   CREATE SEQUENCE public.prenotazione_id_prenotazione_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.prenotazione_id_prenotazione_seq;
       public          fpw    false    205            �           0    0     prenotazione_id_prenotazione_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.prenotazione_id_prenotazione_seq OWNED BY public.prenotazione.id_prenotazione;
          public          fpw    false    204            �            1259    73730    prenotazioneutente    TABLE     �   CREATE TABLE public.prenotazioneutente (
    id integer NOT NULL,
    id_utente bigint,
    id_prenotazione bigint,
    posti_prenotati integer,
    processata character(2)
);
 &   DROP TABLE public.prenotazioneutente;
       public         heap    fpw    false            �            1259    73728    prenotazioneutente_id_seq    SEQUENCE     �   CREATE SEQUENCE public.prenotazioneutente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.prenotazioneutente_id_seq;
       public          fpw    false    211            �           0    0    prenotazioneutente_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.prenotazioneutente_id_seq OWNED BY public.prenotazioneutente.id;
          public          fpw    false    210            �            1259    32773    utente    TABLE     �  CREATE TABLE public.utente (
    id_utente integer NOT NULL,
    username character varying(20),
    password character varying(20),
    nome character varying(50),
    cognome character varying(50),
    email character varying(50),
    cf character(16),
    sesso character varying(100),
    fattura_elett character varying(100),
    foto character varying(200),
    telefono character(10),
    data_nascita date,
    tot_prenotazioni integer
);
    DROP TABLE public.utente;
       public         heap    fpw    false            �            1259    32771    utente_id_utente_seq    SEQUENCE     �   CREATE SEQUENCE public.utente_id_utente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.utente_id_utente_seq;
       public          fpw    false    203            �           0    0    utente_id_utente_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.utente_id_utente_seq OWNED BY public.utente.id_utente;
          public          fpw    false    202            6           2604    49157    amministratore id    DEFAULT     v   ALTER TABLE ONLY public.amministratore ALTER COLUMN id SET DEFAULT nextval('public.amministratore_id_seq'::regclass);
 @   ALTER TABLE public.amministratore ALTER COLUMN id DROP DEFAULT;
       public          fpw    false    208    209    209            5           2604    32792    bagnino id_bagnino    DEFAULT     x   ALTER TABLE ONLY public.bagnino ALTER COLUMN id_bagnino SET DEFAULT nextval('public.bagnino_id_bagnino_seq'::regclass);
 A   ALTER TABLE public.bagnino ALTER COLUMN id_bagnino DROP DEFAULT;
       public          fpw    false    207    206    207            8           2604    81925 
   fattura id    DEFAULT     h   ALTER TABLE ONLY public.fattura ALTER COLUMN id SET DEFAULT nextval('public.fattura_id_seq'::regclass);
 9   ALTER TABLE public.fattura ALTER COLUMN id DROP DEFAULT;
       public          fpw    false    212    213    213            9           2604    98309    messaggio id    DEFAULT     l   ALTER TABLE ONLY public.messaggio ALTER COLUMN id SET DEFAULT nextval('public.messaggio_id_seq'::regclass);
 ;   ALTER TABLE public.messaggio ALTER COLUMN id DROP DEFAULT;
       public          fpw    false    214    215    215            4           2604    32784    prenotazione id_prenotazione    DEFAULT     �   ALTER TABLE ONLY public.prenotazione ALTER COLUMN id_prenotazione SET DEFAULT nextval('public.prenotazione_id_prenotazione_seq'::regclass);
 K   ALTER TABLE public.prenotazione ALTER COLUMN id_prenotazione DROP DEFAULT;
       public          fpw    false    205    204    205            7           2604    73733    prenotazioneutente id    DEFAULT     ~   ALTER TABLE ONLY public.prenotazioneutente ALTER COLUMN id SET DEFAULT nextval('public.prenotazioneutente_id_seq'::regclass);
 D   ALTER TABLE public.prenotazioneutente ALTER COLUMN id DROP DEFAULT;
       public          fpw    false    210    211    211            3           2604    32776    utente id_utente    DEFAULT     t   ALTER TABLE ONLY public.utente ALTER COLUMN id_utente SET DEFAULT nextval('public.utente_id_utente_seq'::regclass);
 ?   ALTER TABLE public.utente ALTER COLUMN id_utente DROP DEFAULT;
       public          fpw    false    202    203    203            �          0    49154    amministratore 
   TABLE DATA           @   COPY public.amministratore (id, username, password) FROM stdin;
    public          fpw    false    209   DJ       �          0    32789    bagnino 
   TABLE DATA           Y   COPY public.bagnino (id_bagnino, nome, cognome, email, attestati, cellulare) FROM stdin;
    public          fpw    false    207   mJ       �          0    81922    fattura 
   TABLE DATA           ^   COPY public.fattura (id, prezzo, data, posti, id_bagnino, descrizione, id_utente) FROM stdin;
    public          fpw    false    213   dK       �          0    98306 	   messaggio 
   TABLE DATA           L   COPY public.messaggio (id, id_user, destinatario, letto, testo) FROM stdin;
    public          fpw    false    215   �K       �          0    32781    prenotazione 
   TABLE DATA           d   COPY public.prenotazione (id_prenotazione, data, id_bagnino, posti_mattina, posti_sera) FROM stdin;
    public          fpw    false    205   yL       �          0    73730    prenotazioneutente 
   TABLE DATA           i   COPY public.prenotazioneutente (id, id_utente, id_prenotazione, posti_prenotati, processata) FROM stdin;
    public          fpw    false    211   �L       �          0    32773    utente 
   TABLE DATA           �   COPY public.utente (id_utente, username, password, nome, cognome, email, cf, sesso, fattura_elett, foto, telefono, data_nascita, tot_prenotazioni) FROM stdin;
    public          fpw    false    203   �L       �           0    0    amministratore_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.amministratore_id_seq', 1, true);
          public          fpw    false    208            �           0    0    bagnino_id_bagnino_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.bagnino_id_bagnino_seq', 15, true);
          public          fpw    false    206            �           0    0    fattura_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.fattura_id_seq', 9, true);
          public          fpw    false    212            �           0    0    messaggio_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.messaggio_id_seq', 13, true);
          public          fpw    false    214            �           0    0     prenotazione_id_prenotazione_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.prenotazione_id_prenotazione_seq', 22, true);
          public          fpw    false    204            �           0    0    prenotazioneutente_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.prenotazioneutente_id_seq', 16, true);
          public          fpw    false    210            �           0    0    utente_id_utente_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.utente_id_utente_seq', 12, true);
          public          fpw    false    202            ?           2606    32794    bagnino bagnino_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.bagnino
    ADD CONSTRAINT bagnino_pkey PRIMARY KEY (id_bagnino);
 >   ALTER TABLE ONLY public.bagnino DROP CONSTRAINT bagnino_pkey;
       public            fpw    false    207            C           2606    81927    fattura fattura_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.fattura
    ADD CONSTRAINT fattura_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.fattura DROP CONSTRAINT fattura_pkey;
       public            fpw    false    213            E           2606    98311    messaggio messaggio_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.messaggio
    ADD CONSTRAINT messaggio_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.messaggio DROP CONSTRAINT messaggio_pkey;
       public            fpw    false    215            =           2606    32786    prenotazione prenotazione_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.prenotazione
    ADD CONSTRAINT prenotazione_pkey PRIMARY KEY (id_prenotazione);
 H   ALTER TABLE ONLY public.prenotazione DROP CONSTRAINT prenotazione_pkey;
       public            fpw    false    205            A           2606    73735 *   prenotazioneutente prenotazioneutente_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.prenotazioneutente
    ADD CONSTRAINT prenotazioneutente_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.prenotazioneutente DROP CONSTRAINT prenotazioneutente_pkey;
       public            fpw    false    211            ;           2606    32778    utente utente_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.utente
    ADD CONSTRAINT utente_pkey PRIMARY KEY (id_utente);
 <   ALTER TABLE ONLY public.utente DROP CONSTRAINT utente_pkey;
       public            fpw    false    203            K           2606    106506    fattura fattura_id_bagnino_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.fattura
    ADD CONSTRAINT fattura_id_bagnino_fkey FOREIGN KEY (id_bagnino) REFERENCES public.bagnino(id_bagnino) ON UPDATE CASCADE;
 I   ALTER TABLE ONLY public.fattura DROP CONSTRAINT fattura_id_bagnino_fkey;
       public          fpw    false    207    213    2879            L           2606    106511    fattura fattura_id_utente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.fattura
    ADD CONSTRAINT fattura_id_utente_fkey FOREIGN KEY (id_utente) REFERENCES public.utente(id_utente) ON UPDATE CASCADE;
 H   ALTER TABLE ONLY public.fattura DROP CONSTRAINT fattura_id_utente_fkey;
       public          fpw    false    213    2875    203            M           2606    98312     messaggio messaggio_id_user_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.messaggio
    ADD CONSTRAINT messaggio_id_user_fkey FOREIGN KEY (id_user) REFERENCES public.utente(id_utente) ON UPDATE CASCADE;
 J   ALTER TABLE ONLY public.messaggio DROP CONSTRAINT messaggio_id_user_fkey;
       public          fpw    false    2875    215    203            N           2606    106516 !   messaggio messaggio_id_user_fkey1    FK CONSTRAINT     �   ALTER TABLE ONLY public.messaggio
    ADD CONSTRAINT messaggio_id_user_fkey1 FOREIGN KEY (id_user) REFERENCES public.utente(id_utente) ON UPDATE CASCADE;
 K   ALTER TABLE ONLY public.messaggio DROP CONSTRAINT messaggio_id_user_fkey1;
       public          fpw    false    203    215    2875            F           2606    32800 )   prenotazione prenotazione_id_bagnino_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.prenotazione
    ADD CONSTRAINT prenotazione_id_bagnino_fkey FOREIGN KEY (id_bagnino) REFERENCES public.bagnino(id_bagnino) ON UPDATE CASCADE;
 S   ALTER TABLE ONLY public.prenotazione DROP CONSTRAINT prenotazione_id_bagnino_fkey;
       public          fpw    false    2879    205    207            H           2606    73741 :   prenotazioneutente prenotazioneutente_id_prenotazione_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.prenotazioneutente
    ADD CONSTRAINT prenotazioneutente_id_prenotazione_fkey FOREIGN KEY (id_prenotazione) REFERENCES public.prenotazione(id_prenotazione) ON UPDATE CASCADE;
 d   ALTER TABLE ONLY public.prenotazioneutente DROP CONSTRAINT prenotazioneutente_id_prenotazione_fkey;
       public          fpw    false    2877    211    205            J           2606    106501 ;   prenotazioneutente prenotazioneutente_id_prenotazione_fkey1    FK CONSTRAINT     �   ALTER TABLE ONLY public.prenotazioneutente
    ADD CONSTRAINT prenotazioneutente_id_prenotazione_fkey1 FOREIGN KEY (id_prenotazione) REFERENCES public.prenotazione(id_prenotazione) ON UPDATE CASCADE;
 e   ALTER TABLE ONLY public.prenotazioneutente DROP CONSTRAINT prenotazioneutente_id_prenotazione_fkey1;
       public          fpw    false    2877    205    211            G           2606    73736 4   prenotazioneutente prenotazioneutente_id_utente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.prenotazioneutente
    ADD CONSTRAINT prenotazioneutente_id_utente_fkey FOREIGN KEY (id_utente) REFERENCES public.utente(id_utente) ON UPDATE CASCADE;
 ^   ALTER TABLE ONLY public.prenotazioneutente DROP CONSTRAINT prenotazioneutente_id_utente_fkey;
       public          fpw    false    211    2875    203            I           2606    106496 5   prenotazioneutente prenotazioneutente_id_utente_fkey1    FK CONSTRAINT     �   ALTER TABLE ONLY public.prenotazioneutente
    ADD CONSTRAINT prenotazioneutente_id_utente_fkey1 FOREIGN KEY (id_utente) REFERENCES public.utente(id_utente) ON UPDATE CASCADE;
 _   ALTER TABLE ONLY public.prenotazioneutente DROP CONSTRAINT prenotazioneutente_id_utente_fkey1;
       public          fpw    false    211    203    2875            �      x�3�t���43�03�����         �   �   x�M��J1����)�e��{��(�"x�2�i;�db���ӛl/��?�Q-�jv���3����!�]9�ʀ1M3K���`�g�����N5�P<c�7>�'W6�ys6�] �F��m"��_���X�6�P�al���jf*QOHU�i漵Q����Q~�h�H�ZZ`��@�l��E	5�#�/x+���,K
��w)���"r��[�Xk����8��"�wB�?��gB      �   ^   x���0�4202�50�5� 29�8�S�3SKJ��s��Rsr��RuLRK��
�K�2����\�@C���@cLH5&F��� �'�      �   �   x�E�1�0��99�7��"p fV�45`)�K�0�r��*V����3ni|?%�������|@a��	#(e�nUqQL����FQ��"������s����y�,0&d�>K��y
�P�	Tb��'(U}B�~�n$�{h��o�E      �   9   x�Eɱ� ��ޅ�m�\�a�9���R�(iJ�� ��z�K���?
.��q>$�P%      �   "   x�34�44�42�46����24�r���=... i��      �   �   x�]��N�0Eדq4�8i�k�"B�EbݍIC4�x�S�~G<���z���%������>AfI�O���r�f��2m��{ם��"�Uh�c�f\��OPk-�4")l��|*H�w���L�n�y�%a�+?�QJ��s�m���y{<�p�<,/c�~��q5���&#Y��Pi��l"���� �I�d� ���tO�o���o%�W2)����P�5j,�eQ_&re2     