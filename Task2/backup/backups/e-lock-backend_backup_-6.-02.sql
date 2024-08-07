PGDMP  3                    |            e-lock-backend    16.3 (Debian 16.3-1.pgdg120+1)    16.3 (Debian 16.3-1.pgdg120+1) @    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16384    e-lock-backend    DATABASE     {   CREATE DATABASE "e-lock-backend" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';
     DROP DATABASE "e-lock-backend";
                postgres    false                        2615    16420    elock    SCHEMA        CREATE SCHEMA elock;
    DROP SCHEMA elock;
                postgres    false            �            1259    16449    area_id_seq    SEQUENCE     s   CREATE SEQUENCE elock.area_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE elock.area_id_seq;
       elock          postgres    false    6            �            1259    16450    area    TABLE     x  CREATE TABLE elock.area (
    id bigint DEFAULT nextval('elock.area_id_seq'::regclass) NOT NULL,
    name character varying(255) NOT NULL,
    campus_id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    version bigint,
    created_by character varying(255),
    updated_by character varying(255)
);
    DROP TABLE elock.area;
       elock         heap    postgres    false    222    6            �            1259    16442    campus    TABLE     Q  CREATE TABLE elock.campus (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    location character varying(255),
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    version bigint,
    created_by character varying(255),
    updated_by character varying(255)
);
    DROP TABLE elock.campus;
       elock         heap    postgres    false    6            �            1259    16441    campus_id_seq    SEQUENCE     u   CREATE SEQUENCE elock.campus_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE elock.campus_id_seq;
       elock          postgres    false    6            �            1259    16421    databasechangelog    TABLE     X  CREATE TABLE elock.databasechangelog (
    id character varying(255) NOT NULL,
    author character varying(255) NOT NULL,
    filename character varying(255) NOT NULL,
    dateexecuted timestamp without time zone NOT NULL,
    orderexecuted integer NOT NULL,
    exectype character varying(10) NOT NULL,
    md5sum character varying(35),
    description character varying(255),
    comments character varying(255),
    tag character varying(255),
    liquibase character varying(20),
    contexts character varying(255),
    labels character varying(255),
    deployment_id character varying(10)
);
 $   DROP TABLE elock.databasechangelog;
       elock         heap    postgres    false    6            �            1259    16426    databasechangeloglock    TABLE     �   CREATE TABLE elock.databasechangeloglock (
    id integer NOT NULL,
    locked boolean NOT NULL,
    lockgranted timestamp without time zone,
    lockedby character varying(255)
);
 (   DROP TABLE elock.databasechangeloglock;
       elock         heap    postgres    false    6            �            1259    16464    door_id_seq    SEQUENCE     s   CREATE SEQUENCE elock.door_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE elock.door_id_seq;
       elock          postgres    false    6            �            1259    16465    door    TABLE     �  CREATE TABLE elock.door (
    id bigint DEFAULT nextval('elock.door_id_seq'::regclass) NOT NULL,
    name character varying(255),
    area_from_id bigint,
    area_to_id bigint,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    version bigint,
    created_by character varying(255),
    updated_by character varying(255)
);
    DROP TABLE elock.door;
       elock         heap    postgres    false    224    6            �            1259    16492    door_permission    TABLE     g   CREATE TABLE elock.door_permission (
    door_id bigint NOT NULL,
    permission_id bigint NOT NULL
);
 "   DROP TABLE elock.door_permission;
       elock         heap    postgres    false    6            �            1259    16507    groups_id_seq    SEQUENCE     u   CREATE SEQUENCE elock.groups_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE elock.groups_id_seq;
       elock          postgres    false    6            �            1259    16508    groups    TABLE     T  CREATE TABLE elock.groups (
    id bigint DEFAULT nextval('elock.groups_id_seq'::regclass) NOT NULL,
    name character varying(255),
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    version bigint,
    created_by character varying(255),
    updated_by character varying(255)
);
    DROP TABLE elock.groups;
       elock         heap    postgres    false    229    6            �            1259    16516    groups_permission    TABLE     j   CREATE TABLE elock.groups_permission (
    group_id bigint NOT NULL,
    permission_id bigint NOT NULL
);
 $   DROP TABLE elock.groups_permission;
       elock         heap    postgres    false    6            �            1259    16483    permission_id_seq    SEQUENCE     y   CREATE SEQUENCE elock.permission_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE elock.permission_id_seq;
       elock          postgres    false    6            �            1259    16484 
   permission    TABLE     \  CREATE TABLE elock.permission (
    id bigint DEFAULT nextval('elock.permission_id_seq'::regclass) NOT NULL,
    name character varying(255),
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    version bigint,
    created_by character varying(255),
    updated_by character varying(255)
);
    DROP TABLE elock.permission;
       elock         heap    postgres    false    226    6            �            1259    16531    student_id_seq    SEQUENCE     v   CREATE SEQUENCE elock.student_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE elock.student_id_seq;
       elock          postgres    false    6            �            1259    16532    student    TABLE     �  CREATE TABLE elock.student (
    id bigint DEFAULT nextval('elock.student_id_seq'::regclass) NOT NULL,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    version bigint,
    created_by character varying(255),
    updated_by character varying(255)
);
    DROP TABLE elock.student;
       elock         heap    postgres    false    232    6            �            1259    16540    student_groups    TABLE     d   CREATE TABLE elock.student_groups (
    student_id bigint NOT NULL,
    group_id bigint NOT NULL
);
 !   DROP TABLE elock.student_groups;
       elock         heap    postgres    false    6            �            1259    16432    user_account    TABLE     �  CREATE TABLE elock.user_account (
    id bigint NOT NULL,
    email character varying(255) NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    version bigint,
    created_by character varying(255),
    updated_by character varying(255)
);
    DROP TABLE elock.user_account;
       elock         heap    postgres    false    6            �            1259    16431    user_id_seq    SEQUENCE     s   CREATE SEQUENCE elock.user_id_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE elock.user_id_seq;
       elock          postgres    false    6            r          0    16450    area 
   TABLE DATA           k   COPY elock.area (id, name, campus_id, created_at, updated_at, version, created_by, updated_by) FROM stdin;
    elock          postgres    false    223            p          0    16442    campus 
   TABLE DATA           l   COPY elock.campus (id, name, location, created_at, updated_at, version, created_by, updated_by) FROM stdin;
    elock          postgres    false    221            k          0    16421    databasechangelog 
   TABLE DATA           �   COPY elock.databasechangelog (id, author, filename, dateexecuted, orderexecuted, exectype, md5sum, description, comments, tag, liquibase, contexts, labels, deployment_id) FROM stdin;
    elock          postgres    false    216            l          0    16426    databasechangeloglock 
   TABLE DATA           Q   COPY elock.databasechangeloglock (id, locked, lockgranted, lockedby) FROM stdin;
    elock          postgres    false    217            t          0    16465    door 
   TABLE DATA           z   COPY elock.door (id, name, area_from_id, area_to_id, created_at, updated_at, version, created_by, updated_by) FROM stdin;
    elock          postgres    false    225            w          0    16492    door_permission 
   TABLE DATA           @   COPY elock.door_permission (door_id, permission_id) FROM stdin;
    elock          postgres    false    228            y          0    16508    groups 
   TABLE DATA           b   COPY elock.groups (id, name, created_at, updated_at, version, created_by, updated_by) FROM stdin;
    elock          postgres    false    230            z          0    16516    groups_permission 
   TABLE DATA           C   COPY elock.groups_permission (group_id, permission_id) FROM stdin;
    elock          postgres    false    231            v          0    16484 
   permission 
   TABLE DATA           f   COPY elock.permission (id, name, created_at, updated_at, version, created_by, updated_by) FROM stdin;
    elock          postgres    false    227            |          0    16532    student 
   TABLE DATA           {   COPY elock.student (id, email, first_name, last_name, created_at, updated_at, version, created_by, updated_by) FROM stdin;
    elock          postgres    false    233            }          0    16540    student_groups 
   TABLE DATA           =   COPY elock.student_groups (student_id, group_id) FROM stdin;
    elock          postgres    false    234            n          0    16432    user_account 
   TABLE DATA           �   COPY elock.user_account (id, email, first_name, last_name, created_at, updated_at, version, created_by, updated_by) FROM stdin;
    elock          postgres    false    219            �           0    0    area_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('elock.area_id_seq', 20, true);
          elock          postgres    false    222            �           0    0    campus_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('elock.campus_id_seq', 9, true);
          elock          postgres    false    220            �           0    0    door_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('elock.door_id_seq', 33, true);
          elock          postgres    false    224            �           0    0    groups_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('elock.groups_id_seq', 8, true);
          elock          postgres    false    229            �           0    0    permission_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('elock.permission_id_seq', 8, true);
          elock          postgres    false    226            �           0    0    student_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('elock.student_id_seq', 5, true);
          elock          postgres    false    232            �           0    0    user_id_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('elock.user_id_seq', 4, true);
          elock          postgres    false    218            �           2606    16430 0   databasechangeloglock databasechangeloglock_pkey 
   CONSTRAINT     m   ALTER TABLE ONLY elock.databasechangeloglock
    ADD CONSTRAINT databasechangeloglock_pkey PRIMARY KEY (id);
 Y   ALTER TABLE ONLY elock.databasechangeloglock DROP CONSTRAINT databasechangeloglock_pkey;
       elock            postgres    false    217            �           2606    16457    area pk_area_account 
   CONSTRAINT     Q   ALTER TABLE ONLY elock.area
    ADD CONSTRAINT pk_area_account PRIMARY KEY (id);
 =   ALTER TABLE ONLY elock.area DROP CONSTRAINT pk_area_account;
       elock            postgres    false    223            �           2606    16448    campus pk_campus_account 
   CONSTRAINT     U   ALTER TABLE ONLY elock.campus
    ADD CONSTRAINT pk_campus_account PRIMARY KEY (id);
 A   ALTER TABLE ONLY elock.campus DROP CONSTRAINT pk_campus_account;
       elock            postgres    false    221            �           2606    16472    door pk_door_account 
   CONSTRAINT     Q   ALTER TABLE ONLY elock.door
    ADD CONSTRAINT pk_door_account PRIMARY KEY (id);
 =   ALTER TABLE ONLY elock.door DROP CONSTRAINT pk_door_account;
       elock            postgres    false    225            �           2606    16496 "   door_permission pk_door_permission 
   CONSTRAINT     s   ALTER TABLE ONLY elock.door_permission
    ADD CONSTRAINT pk_door_permission PRIMARY KEY (door_id, permission_id);
 K   ALTER TABLE ONLY elock.door_permission DROP CONSTRAINT pk_door_permission;
       elock            postgres    false    228    228            �           2606    16515    groups pk_groups_account 
   CONSTRAINT     U   ALTER TABLE ONLY elock.groups
    ADD CONSTRAINT pk_groups_account PRIMARY KEY (id);
 A   ALTER TABLE ONLY elock.groups DROP CONSTRAINT pk_groups_account;
       elock            postgres    false    230            �           2606    16520 &   groups_permission pk_groups_permission 
   CONSTRAINT     x   ALTER TABLE ONLY elock.groups_permission
    ADD CONSTRAINT pk_groups_permission PRIMARY KEY (group_id, permission_id);
 O   ALTER TABLE ONLY elock.groups_permission DROP CONSTRAINT pk_groups_permission;
       elock            postgres    false    231    231            �           2606    16491     permission pk_permission_account 
   CONSTRAINT     ]   ALTER TABLE ONLY elock.permission
    ADD CONSTRAINT pk_permission_account PRIMARY KEY (id);
 I   ALTER TABLE ONLY elock.permission DROP CONSTRAINT pk_permission_account;
       elock            postgres    false    227            �           2606    16539    student pk_student_account 
   CONSTRAINT     W   ALTER TABLE ONLY elock.student
    ADD CONSTRAINT pk_student_account PRIMARY KEY (id);
 C   ALTER TABLE ONLY elock.student DROP CONSTRAINT pk_student_account;
       elock            postgres    false    233            �           2606    16544     student_groups pk_student_groups 
   CONSTRAINT     o   ALTER TABLE ONLY elock.student_groups
    ADD CONSTRAINT pk_student_groups PRIMARY KEY (student_id, group_id);
 I   ALTER TABLE ONLY elock.student_groups DROP CONSTRAINT pk_student_groups;
       elock            postgres    false    234    234            �           2606    16438    user_account pk_user_account 
   CONSTRAINT     Y   ALTER TABLE ONLY elock.user_account
    ADD CONSTRAINT pk_user_account PRIMARY KEY (id);
 E   ALTER TABLE ONLY elock.user_account DROP CONSTRAINT pk_user_account;
       elock            postgres    false    219            �           2606    16440 #   user_account user_account_email_key 
   CONSTRAINT     ^   ALTER TABLE ONLY elock.user_account
    ADD CONSTRAINT user_account_email_key UNIQUE (email);
 L   ALTER TABLE ONLY elock.user_account DROP CONSTRAINT user_account_email_key;
       elock            postgres    false    219            �           2606    16497 *   door_permission fk_door_permission_on_door    FK CONSTRAINT     �   ALTER TABLE ONLY elock.door_permission
    ADD CONSTRAINT fk_door_permission_on_door FOREIGN KEY (door_id) REFERENCES elock.door(id) ON DELETE CASCADE;
 S   ALTER TABLE ONLY elock.door_permission DROP CONSTRAINT fk_door_permission_on_door;
       elock          postgres    false    228    225    3270            �           2606    16502 0   door_permission fk_door_permission_on_permission    FK CONSTRAINT     �   ALTER TABLE ONLY elock.door_permission
    ADD CONSTRAINT fk_door_permission_on_permission FOREIGN KEY (permission_id) REFERENCES elock.permission(id) ON DELETE CASCADE;
 Y   ALTER TABLE ONLY elock.door_permission DROP CONSTRAINT fk_door_permission_on_permission;
       elock          postgres    false    227    228    3272            �           2606    16521 0   groups_permission fk_groups_permission_on_groups    FK CONSTRAINT     �   ALTER TABLE ONLY elock.groups_permission
    ADD CONSTRAINT fk_groups_permission_on_groups FOREIGN KEY (group_id) REFERENCES elock.groups(id) ON DELETE CASCADE;
 Y   ALTER TABLE ONLY elock.groups_permission DROP CONSTRAINT fk_groups_permission_on_groups;
       elock          postgres    false    231    230    3276            �           2606    16526 4   groups_permission fk_groups_permission_on_permission    FK CONSTRAINT     �   ALTER TABLE ONLY elock.groups_permission
    ADD CONSTRAINT fk_groups_permission_on_permission FOREIGN KEY (permission_id) REFERENCES elock.permission(id) ON DELETE CASCADE;
 ]   ALTER TABLE ONLY elock.groups_permission DROP CONSTRAINT fk_groups_permission_on_permission;
       elock          postgres    false    231    227    3272            �           2606    16550 *   student_groups fk_student_groups_on_groups    FK CONSTRAINT     �   ALTER TABLE ONLY elock.student_groups
    ADD CONSTRAINT fk_student_groups_on_groups FOREIGN KEY (group_id) REFERENCES elock.groups(id) ON DELETE CASCADE;
 S   ALTER TABLE ONLY elock.student_groups DROP CONSTRAINT fk_student_groups_on_groups;
       elock          postgres    false    230    3276    234            �           2606    16545 +   student_groups fk_student_groups_on_student    FK CONSTRAINT     �   ALTER TABLE ONLY elock.student_groups
    ADD CONSTRAINT fk_student_groups_on_student FOREIGN KEY (student_id) REFERENCES elock.student(id) ON DELETE CASCADE;
 T   ALTER TABLE ONLY elock.student_groups DROP CONSTRAINT fk_student_groups_on_student;
       elock          postgres    false    234    3280    233            �           2606    16458    area fr_area_on_campus    FK CONSTRAINT     v   ALTER TABLE ONLY elock.area
    ADD CONSTRAINT fr_area_on_campus FOREIGN KEY (campus_id) REFERENCES elock.campus(id);
 ?   ALTER TABLE ONLY elock.area DROP CONSTRAINT fr_area_on_campus;
       elock          postgres    false    221    223    3266            �           2606    16473    door fr_door_from_on_area    FK CONSTRAINT     z   ALTER TABLE ONLY elock.door
    ADD CONSTRAINT fr_door_from_on_area FOREIGN KEY (area_from_id) REFERENCES elock.area(id);
 B   ALTER TABLE ONLY elock.door DROP CONSTRAINT fr_door_from_on_area;
       elock          postgres    false    3268    223    225            �           2606    16478    door fr_door_to_on_area    FK CONSTRAINT     v   ALTER TABLE ONLY elock.door
    ADD CONSTRAINT fr_door_to_on_area FOREIGN KEY (area_to_id) REFERENCES elock.area(id);
 @   ALTER TABLE ONLY elock.door DROP CONSTRAINT fr_door_to_on_area;
       elock          postgres    false    225    3268    223            r   S  x����r� ���)�2�����^�2mgb�������`[1����Yv#����W�+�ɓ󌲳�-�A֣���щ����n�v�?���ym�����r�����c:���I��H�T� �S
��f��E�Y{0�c@/!�>�q�����|ݽ�?����(���^K~�|w��"��I�xj_�S)�Pj�j��ZF~�iX�++�.��_�~*�5�<����y���_Ir��-�����?���F;S��j�Vz�r#A=������B�CKM��.���q*��/@"9ִ�*v�Kv�������c��G���l��k[4�      p   �   x�}Ͽn�0���x
^ �w糱�,�*e��-��P�b��/����G����s�|�d
-��0 r�d�,o��>���YU���!��M�J��-Zk�F���B~C֊�	��g���i����6���Ԇ��ۺꞵ�]�PŶ8�*ޚt��!
ls�B?	]�e]B�K�o�{x9������@���<.J���U�p�}�qR]��t�N����j�_G�e�'$ӂ      k     x����n�8����8��G�^ir�h\�)Ћ%�Ycc)+���K�'�U[��@�!�g���	$�1`$*dY�8�t٪uMf��^U�li�g٪�^�����S񏭞�s�����d�8�+y����^��b��S�	p�QG������x�%�����=g
�o|��<WF�:��+W.n�/�v��Z��Yh�o�����D�%��Eѯ�H$L$н��B���4�� ��X��˪�PRG\�g�PP��1R��S��1RP�B4%��:�G3ږOi#:?&�߭̆����d#c�i�N�$�u����E�=HϜWhr*D)s�Xh�Ҏf�.:�L'�۲��7��v�7u�.;��qn�͈7�4.޺׍w����u6��n��~��}7λ��D�x���F�V*���ʺn>@���>1Ô�T����G�O@Jϥ������-�k#�Q��:ɹ:�!_f����a�����8�أ�g�,I�?qj ��1���T@�Q�P��f1o�y]]��S���é�u`�m.�>�p^��\[� 4�p��J�R8E�+=�]8������[3_��5 Bx�7���:�۰�h���2��}��G�yj����T���E3�2��yi�a��@=��O0��:!����r�A�Q�몧n��h��"����;�`�A�&dNLH���;�v�*����lP��R�:!�A�H��jo�a+�$c�p[p�i����j��8խ�Dw����~:�t͡ߦ�a�B�{J�'���d�?�\�Y      l      x�3�L��"�=... U�      t   1  x���Mn�0���)r�")Q?���.�ݸ�13@RNR �II��X��O$E��x�������� % *���5p0$"|�8r�ĥ����_���}��y�<��<w���
�Ȉ��JL�H�� ^"��Q(� �;	����0��U=���r�]�4��a~���&ڠT@�����T�I��֝?T.hj	A+�-"�%�E�	3MO-1�J�ӢԢфF�fjKT�2��Gi�t��Ϗ[L"�kS��jnw���3"��$M#) J����(��3K������5�J�Mr�\�f3�J����`�4ޣ�j+��b�o��l��)����Hp�֛QJ��\�z�3ř 6~�NӢ������H���&I��K��J5���-���!�m.�D��\6;�l &�Z4�R����%���(}�6�kIj�1����g�K��%�E�7R��$�!i��,���%��$�v]!�%KG�O�|��^Ӣ�����iX[���^��t�88��/K�;��I��߇��^�C�a�}2��<Ҟ�R+M�&��S����O���j��L+V1      w   G   x�˱�0��U�^�^�|$�H�T�ԐWMy���.ͥo�������,d��YK�YzI<�&      y   �   x�}�1�0k��@�ۻ����hhS�� ���8�R�����Ys��{�;&։l���&�f�4 �k���"�nEi�!��e	ЪV�gQ�g�+K���p�.*�n��k��cb��[E#���l���E�=�      z      x�3�4�2cS.c m�i����� )�      v   �   x���9�0��9E.����N�*'�����H�D�"q{	� ��Ѽ�ǔ�bd]�-�����N���JOd�+Q��i�I�Շ6���t��m2�t�s��LE��(�4[�?�Rm�i/�{N6�;�<1���F�*Tא��f軾��ͱ�L)�|���mlR\�zdp�j�֪?/;Ȳ��F]      |   �   x�}�M
�0���)��a&���nn��?�F"
޾RB-��->�}o���=��+EFv���A�!��J�%V���B-��Fg��:.>4��]ޝ�JN�qRr�W���a�s��:+����mbs����Nk�bu�;'�Q��E<>Z*0&�0�8&t�s�J�b�      }      x�3�4�2�4�2�������        n   �   x�}�K
�@D�=��6��UW� 	��2$��%�>�#B��ѯJ@�^�;״X���+��r�R�*H���L��B���$����G�����ؿ��Ei�V��n��@��bZ7a�0����������bs��r��LJ&!S�e�E�\J��֒
cO�E.     