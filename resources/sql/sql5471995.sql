-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Host: sql5.freemysqlhosting.net
-- Generation Time: Mar 03, 2022 at 05:39 AM
-- Server version: 5.5.62-0ubuntu0.14.04.1
-- PHP Version: 7.0.33-0ubuntu0.16.04.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sql5471995`
--

-- --------------------------------------------------------

--
-- Table structure for table `preguntas_biologia`
--

CREATE TABLE `preguntas_biologia` (
  `id` int(50) NOT NULL,
  `pregunta` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta1` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta2` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta3` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta4` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Esta tabla registra las preguntas de literatura';

--
-- Dumping data for table `preguntas_biologia`
--

INSERT INTO `preguntas_biologia` (`id`, `pregunta`, `respuesta1`, `respuesta2`, `respuesta3`, `respuesta4`) VALUES
(1, '¿Cual de estos científicos NO se dedicó al estudio de la evolución?', 'Charles Darwin.', 'Jean Baptiste de Lamarck.', 'Alfred Rusell Wallace.', '*Carl Linneo.'),
(2, 'Es el reino biológico según la clasificación de Whittaker donde se encuentran las algas.', 'Monera.', '*Protista.', 'Fungí.', 'Animalia.'),
(3, 'Es el reino biológico donde sus integrantes se componen únicamente de una célula.', '*Monera.', 'Protista.', 'Fungí.', 'Animalia.'),
(4, '¿Cuál de estos nucleótidos no puede estar presente en una cadena de ADN?', 'Adenina.', 'Timina.', 'Guanina.', '*Uracilo.'),
(5, '¿Qué clase de animales cuentan con un mayor porcentaje de endemismo en México?', 'Los reptiles.', '*Los anfibios.', 'Los mamíferos.', 'Las aves.'),
(6, 'El cáncer se genera por cambios en el organismo conocidos como…', '*Mutaciones.', 'Especiaciones.', 'Migraciones.', 'Evoluciones.'),
(7, 'Las evidencias evolutivas donde se encuentra el estudio de los fósiles son…', 'Las evidencias geológicas.', 'Las evidencias anatómicas.', 'Las evidencias embriológicas.', '*Las evidencias paleontológicas.'),
(8, '¿Quiénes fueron los científicos que desarrollaron el primer microscopio compuesto?', '*Jans y Zacharias Jensen.', 'Galileo Galilei y Johannes Kepler.', 'Leonardo da Vinci y Federico Cesi.', 'Robert e Isaiah Hooke.'),
(9, '¿Cuál de estas características NO se encuentra en todos los seres vivos?', 'Realizar Homeostasis.', 'Cuentan con células.', '*Se reproducen de manera sexual.', 'Intercambian energía y materia.'),
(10, '¿Cuántos átomos de carbono hay en una molécula de glucosa?', '4 átomos de carbono.', '*6 átomos de carbono.', '8 átomos de carbono.', '10 átomos de carbono.'),
(11, '¿Cual de las siguientes opciones NO es producto de la fotosíntesis?', '*Vapor de agua', 'Glucosa', 'Adenosín Trifosfato', 'Oxígeno diatómico'),
(12, '¿Cuántos pares de cromosomas tiene un ser humano promedio?', '*23 pares de cromosomas', '46 pares de cromosomas', '13 pares de cromosomas', '16 pares de cromosomas'),
(13, '¿Qué diferencia a una vitamina de un mineral?', 'El aporte nutrimental al organismo.', '*Que las vitaminas son de origen orgánico y los minerales de origen inorgánico.', 'Que las vitaminas no aparecen en la tabla periódica y los minerales si.', 'Que los minerales sólo están presentes en vegetales.'),
(14, 'La selección artificial se presenta solamente por la intervención de…', 'Otros seres vivos', '*Acción del hombre', 'Fenómeno de traslación terrestre', 'Erosión de los suelos'),
(15, '¿Cuál es el organelo más importante en la respiración celular en cualquier organismo?', 'El núcleo.', 'El cloroplasto.', '*La mitocondria.', 'Los ribosomas.'),
(16, 'Cuando hablamos de la ciencia, la ciencia encargada de clasificar, denominar y describir a los seres vivos, nos referimos a…', 'La micología.', '*La taxonomía.', 'La virología.', 'La ecología.'),
(17, '¿Cuál de estos científicos NO aportó a la teoría celular?', 'Rudolf Virchow', 'Robert Brown', 'Theodor Schwann', '*Martin Boyle.'),
(18, 'Todos los organismos vivos están formados por…', 'Órganos.', '*Células.', 'Tejidos.', 'Huesos.'),
(19, '¿Cuál es el porcentaje de biodiversidad mundial que se concentra en México?', '8 a 10 por ciento.', '15 a 20 por ciento.', '*10 a 12 por ciento.', '20 a 25 por ciento.'),
(20, '¿Cuál de los siguientes problemas es el que causa más endemismo en nuestro país?', '*Pérdida de hábitats.', 'Especies invasoras.', 'Sobreexplotación.', 'Contaminación.'),
(21, '¿Cómo se le denomina a la relación que existe entre los habitantes de una especie con respecto al área abarcada?', 'Abundancia.', 'Volumen.', '*Densidad.', 'Distribución'),
(22, '¿Cuáles de las siguientes son causas naturales del cambio climático?', 'La acción industrial y la inclinación de la tierra.', 'La acción industrial y la tala excesiva.', '*El movimiento de traslación y las características del sol como estrella.', 'La distancia con el sol y el empleo de combustibles fósiles.'),
(23, 'Las especies introducidas a un ambiente ajeno y que generan daños al mismo, se les llaman…', 'Endémicas.', 'Nativas.', 'Exóticas.', '*Invasoras. '),
(24, '¿Cuáles de estos son los gases de efecto invernadero más preocupantes?', '*CO2, N2O y CH4.', 'O3, C2H6 y N2O.', 'Ne, C4H4, CO2.', 'CH4, SO2, H2.'),
(25, 'Los hongos y las bacterias en una red trófica toman el rol de…', 'Productores. ', '*Descomponedores.', 'Consumidores primarios.', 'Consumidores terciarios.'),
(26, '¿Cuáles de estos factores influyen positivamente en el crecimiento poblacional?', '*Inmigración y natalidad.', 'Mortalidad y emigración.', 'Mortalidad y evolución', 'Natalidad y expansión.'),
(27, '¿Cuál característica de las siguientes NO presenta un tumor canceroso?', 'Generan otros tumores..', 'Evade al sistema inmune.', 'Pueden migrar cubriendo todo el organismo.', '*Las células tumorales están unidas.'),
(28, '¿Qué cruza genética representa con exactitud a la primera ley de Mendel?', 'Aa x aa', 'AA X Aa', 'aa x aa', '*AA x aa'),
(29, '¿De qué está compuesta la estructura de los virus como el del VIH o el SARS-COV 2 ?', 'ADN envoltura nuclear y cápside.', 'ADN  y cápside.', 'ARN y cápside.', '*ARN, envoltura nuclear y cápside.'),
(30, '¿Cuál es la importancia de los organismos fotosintéticos en el combate del calentamiento global?', '*Fijan el carbono, reduciendo la cantidad de CO2 en la atmósfera.', 'Producen vapor de agua, disipando el CO2 en la atmósfera.', 'Sirven de alimento para los consumidores. ', 'Desarrollan O3, reforzando a la capa de ozono.');

-- --------------------------------------------------------

--
-- Table structure for table `preguntas_derecho`
--

CREATE TABLE `preguntas_derecho` (
  `id` int(50) NOT NULL,
  `pregunta` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta1` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta2` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta3` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta4` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Esta tabla registra las preguntas de literatura';

--
-- Dumping data for table `preguntas_derecho`
--

INSERT INTO `preguntas_derecho` (`id`, `pregunta`, `respuesta1`, `respuesta2`, `respuesta3`, `respuesta4`) VALUES
(1, 'El artículo constitucional que establece el derecho a la educación es…', 'Artículo 1ero.', 'Artículo 4to.', '*Artículo 3ero.', 'Artículo 5to.'),
(2, '¿Cuál de estas NO es una fuente del derecho?', 'Fuente formal.', '*Fuente social.', 'Fuente histórica.', 'Fuente real.'),
(3, '¿Qué filósofo definió a la justicia como “Darle a cada uno lo suyo”?', 'Aristóteles', 'Jeremias Bentham', 'Platón', '*Ulpiano'),
(4, 'El ser autónomas, es una característica que únicamente le pertenece a las normas…', '*Morales', 'Sociales', 'Jurídicas', 'Naturales'),
(5, '¿Cuál de las siguientes características se presenta en las normas jurídicas?', 'Son unilaterales', 'Son autónomas', 'Son libres', '*Son coercibles'),
(6, '¿En qué parte de la constitución se encuentran los primeros 29 artículos?', 'En la parte documental', '*En la parte dogmática', 'En la parte orgánica', 'En la parte inorgánica'),
(7, '¿Cuál es el mínimo de votos que se requiere para que se apruebe una propuesta de ley como mayoría calificada?', '¾ partes', '⅝ partes', '*⅔ partes', '¼ partes'),
(8, '¿Cuál es el porcentaje de ciudadanía necesario para comenzar una iniciativa de ley?', '13 por ciento', '15 por ciento', '1.5 por ciento', '*0.13 por ciento'),
(9, 'Los dos tipos de sentencia que existen son…', 'Absoluta y Relativa.', 'Condenatoria y Discriminatoria.', '*Condenatoria y Absolutoria.', 'Discriminatoria y Relativa.'),
(10, 'El derecho privado se subdivide en…', '*Derecho Civil y Mercantil.', 'Derecho Patrimonial y Procesal.', 'Derecho Judicial y Penal.', 'Derecho Agrario y Educativo.'),
(11, '¿Cúal de las siguientes normas jurídicas individualizadas, involucra en su proceso, el dejar bienes después de morir?', 'Sentencia.', 'Resolución administrativa.', '*Testamento.', 'Contrato.'),
(12, 'El medio por el cual el poder ejecutivo puede aclarar directamente la aplicación de una ley es mediante…', 'Un acuerdo internacional.', '*Un reglamento.', 'Una constitución.', 'Un decreto.'),
(13, 'La edad mínima que debe de tener una persona para considerarse como ciudadano son los…', '15 años', '*18 años', '17 años ', '21 años'),
(14, 'El resultado lógico que se presenta al cumplirse la hipótesis normativa es…', 'Supuesto de hecho. ', '*Consecuencia jurídica. ', 'Axioma. ', 'Fundamentación.'),
(15, '¿Cuál es la fuente del derecho que se obtiene por reiteración o por contradicción de tesis?', '*Jurisprudencia. ', 'Doctrina. ', 'Principios Generales del Derecho. ', 'Costumbre'),
(16, 'Según el artículo 19 de la constitución ¿Cuánto es el tiempo máximo que puede durar una detención?', '16 horas', '*72 horas', '24 horas', '48 horas'),
(17, 'La parte del proceso legislativo donde el Presidente firma de aceptado el proyecto de ley es...', 'Derecho de veto..', 'Publicación. ', 'Aprobación.', '*Promulgación'),
(18, 'La acción de quitar del texto de la ley una parte, un párrafo o un numeral se le llama...', 'Abrogar.', 'Conciliar.', '*Derogar.', 'Aprobar.'),
(19, 'El derecho lo podemos dividir principalmente en…', 'Derecho Civil y Derecho Extranjero,', 'Derecho Público y Derecho Privado.', 'Derecho Político  Derecho Objetivo.', '*Derecho Objetivo y Derecho Subjetivo.'),
(20, 'Uno de los objetivos principales de los derechos sociales es…', '*Proteger a las clases más desfavorecidas.', 'Regular la relación entre particulares.', 'Ver por el desarrollo económico de unos cuantos.', 'Regular la organización de los tribunales.'),
(21, '¿A cuáles preguntas el derecho romano civil les da respuesta?', '¿Dónde vives? y ¿Quien eres?', '*¿Qué tienes? y ¿Quién eres?', '¿Cuándo naciste? y ¿Quienes son tus padres?', '¿Dónde viviste? y ¿Qué posees?'),
(22, '¿Qué garantía constitucional se cubre con el artículo 27 constitucional?', '*La garantía de propiedad.', 'La garantía de libertad.', 'La garantía de responsabilidad..', 'La garantía de seguridad jurídica.'),
(23, '¿A cuál de los siguientes documentos, también lo conocemos como “La Carta Magna”?', 'El Código Penal.', 'El Código Civil.', '*La Constitución de los Estados Unidos Mexicanos.', 'Ley Federal del Trabajo.'),
(24, 'La constitución de nuestro país se compone de…', '*9 capítulos y 136 artículos (sin contar los transitorios).', '9 capítulos y 136 artículos (contando los transitorios).', '7 capítulos y 136 artículos (contando los transitorios).', '9 capítulos y 126 artículos (sin contar los transitorios).'),
(25, 'En el artículo primero de la constitución podemos ver las garantías…', 'De igualdad y de seguridad jurídica.', 'De propiedad y de equidad.', 'De equidad y libertad.', '*De libertad y de igualdad. '),
(26, 'Al contrato civil con virtud donde una persona le entrega un bien mueble a otro sin costo, nos referimos a él comúnmente como…', 'Cesión.', 'Traspaso.', '*Donación.', 'Compra.'),
(27, '¿Cuál de los siguientes artículos constitucionales NO toca el derecho económico?', 'Artículo 25.', 'Artículo 26.', 'Artículo 28.', '*Artículo 29.'),
(28, 'La regla áurea tiene como principio…', 'Todos los hombres somos hermosos.', '*El no hacerle a los demás lo que no queremos que nos hagan.', 'Todos los hombres somos iguales.', 'Todos los hombres somos iguales ante la ley.'),
(29, '¿Cuáles son los elementos que componen a un estado?', '*La población, territorio y gobierno.', 'El territorio, los políticos  y gobierno.', 'La población, territorio y soberanía.', 'Las leyes, las personas y la moral.'),
(30, '¿Cuál de las siguientes ramas del derecho NO pertenecen al derecho público?', 'Derecho Constitucional.', '*Derecho Agrario.', 'Derecho Penal', 'Derecho Administrativo.');

-- --------------------------------------------------------

--
-- Table structure for table `preguntas_fisica`
--

CREATE TABLE `preguntas_fisica` (
  `id` int(50) NOT NULL,
  `pregunta` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta1` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta2` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta3` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta4` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Esta tabla registra las preguntas de literatura';

--
-- Dumping data for table `preguntas_fisica`
--

INSERT INTO `preguntas_fisica` (`id`, `pregunta`, `respuesta1`, `respuesta2`, `respuesta3`, `respuesta4`) VALUES
(1, 'La distancia existente entre cresta y cresta de una onda es la …', 'Amplitud de onda.', '*Longitud de onda.', 'Transversalidad de la onda.', 'Frecuencia de onda.'),
(2, '¿En qué rama de la física se encuentra la ecuación de Bernoulli?', '*Hidrodinámica.', 'Termodinámica.', 'Acústica.', 'Óptica.'),
(3, '¿Qué elementos componen a un marcapasos?', 'Corriente alterna, pila, capacitor y bobina.', 'Inductores, focos, corriente alterna y diodos.', 'Corriente trifásica, bobina, led y fusible.', '*Pila, resistencias, corriente directa y capacitores.'),
(4, 'Cuando hablamos de la unidad “años luz” ¿qué estamos midiendo?', 'Tiempo.', 'Temperatura.', 'Potencia.', '*Distancia.'),
(5, '¿Cuál es el sentido del cuerpo humano capaz de detectar el sonido?', 'El sentido del gusto.', 'El sentido del olfato.', '*El sentido del oído.', 'El sentido de la vista.'),
(6, '¿Qué tipo de ciclo termodinámico aplica un vehículo que funciona con gasolina?', '*Ciclo de Otto.', 'Ciclo de Rankine', 'Ciclo Diesel', 'Ciclo de Carnot'),
(7, 'El sonido viaja a mayor rapidez en materiales como…', 'El agua y el acero.', '*El acero y el hierro.', 'El vidrio y el concreto.', 'El agua y el hierro.'),
(8, '¿Cómo se subclasifican las ondas mecánicas?', 'En oscilatorias y transversales.', 'En superficiales y oscilatorias.', '*En transversales y longitudinales.', 'En longitudinales y trepidatorias.'),
(9, '¿Qué son capaces de transportar las ondas durante su viaje?', 'Materia y energía.', 'Sonido y materia.', 'Sonido y trabajo.', '*Solamente energía.'),
(10, 'El enunciado “La fuerza de atracción de dos cargas es directamente proporcional al producto de sus cargas e inversamente proporcional al cuadrado de sus distancias”, fue propuesto por…', '*Charles-Augustin de Coulomb.', 'Isaac Newton.', 'Heinrich Lenz.', 'Albert Einstein'),
(11, '¿Cuál es la rama de la física encargada de estudiar los alrededores de un sistema y del cómo se intercambia energía?', 'Mecánica.', 'Óptica.', '*Termodinámica.', 'Termoeléctrica.'),
(12, 'La diferencia entre una magnitud escalar y una vectorial es…', 'La rama de la física donde se aplica.', 'La magnitud escalar cuenta con dirección y sentido, mientras que la vectorial no.', 'Solo la magnitud escalar puede representar un movimiento parabólico.', '*La magnitud vectorial cuenta con dirección y sentido, mientras que la escalar no.'),
(13, '¿Cuáles de estos NO son tipos de sistemas termodinámicos ?', 'Abiertos.', 'Cerrados.', '*Cruzados.', 'Aislados.'),
(14, 'El Ciclo de Carnot está compuesto por…', '2 procesos adiabáticos y 2 isocóricos.', '2 procesos isotérmicos y 2 isométricos.', '*2 procesos isotérmicos y 2 adiabáticos.', '2 procesos isocóricos y 2 procesos isotérmicos.'),
(15, 'Las energías no utilizables en un sistema termodinámico se conocen como…', 'La entalpía', '*La entropía', 'La radiación', 'La cuantización'),
(16, '¿Cuántas son las unidades de medida establecidas en el SIU?', '*7 unidades', '5 unidades', '6 unidades', '9 unidades'),
(17, '¿Cuál de las siguientes ecuaciones NO se utiliza en la medicina?', '*Ecuación de Ergun.', 'Ecuación de Poiseuille.', 'Ecuación de Bernoulli.', 'Ecuación de Continuidad.'),
(18, '¿Cuál de estos padecimientos NO se debe a una deformación en el ojo?', 'Miopía.', 'Astigmatismo.', 'Hipermetropía.', '*Ambliopía.'),
(19, 'La magnitud vectorial que mide la capacidad de mover, detener, redireccionar o deformar un cuerpo es la…', 'Energía.', 'Velocidad.', '*Fuerza.', 'Trayectoria.'),
(20, 'Los trabajos del científico Isaac Newton destacaron principalmente en la rama de la física conocida como…', 'Metafísica', '*Mecánica', 'Termodinámica', 'Astronomía '),
(21, 'Quien describió a la fuerza de gravedad como aquella fuerza descendente que actúa sobre los cuerpos atrayendo sus masas hacia sus centros fue…', 'Isaac Asimov.', 'Isaac Newton.', 'Johannes Kepler.', '*Galileo Galilei.'),
(22, '¿Qué magnitud representa el cambio de velocidad de un cuerpo con respecto al tiempo?', '*Aceleración.', 'Energía.', 'Masa.', 'Fuerza.'),
(23, 'La rama de la física encargada de describir el movimiento de los cuerpos es la…', 'Termodinámica.', 'Astrofísica.', '*Cinemática.', 'Acústica.'),
(24, '¿Cuál de los siguientes ejemplos NO es un tipo de movimiento?', 'Movimiento Rectilineo Uniforme.', '*Movimiento Curvilíneo Uniforme.', 'Movimiento Armónico Simple.', 'Movimiento Rectilíneo Uniformemente Acelerado.'),
(25, 'El enunciado de Newton que describe la fuerza como el producto de la masa y la aceleración es la…', 'Ley de la gravitación universal.', '*Segunda ley de Newton.', 'Tercera Ley de Newton.', 'Ley de la conservación de la masa.'),
(26, 'La ecuación “v=d/t” se utiliza para calcular…', 'La aceleración centrífuga.', 'La velocidad instantánea.', '*La velocidad promedio.', 'La aceleración centrípeta.'),
(27, 'Al peso de la columna de aire que hay sobre cualquier punto o lugar de la Tierra, lo conocemos como…', '*Presión atmosférica.', 'Presión hidrostática.', 'Peso.', 'Presión manométrica.'),
(28, '¿En qué unidad se suele expresar la presión arterial?', 'Moles.', 'Atmósferas.', 'Pascales.', '*Milímetros de mercurio.'),
(29, '¿Cuáles son los niveles de presión arterial a los cuales un humano común debe de estar por debajo?', '*120/80 mmHg.', '130/90 mmHg.', '110/100 mmHg.', '150/90 mmHg.'),
(30, '¿Cuál es la rama de la física que estudia a los fluidos en movimiento?', 'Hidroeléctrica.', 'Hidráulica.', 'Acústica.', '*Hidrodinámica.');

-- --------------------------------------------------------

--
-- Table structure for table `preguntas_literatura`
--

CREATE TABLE `preguntas_literatura` (
  `id` int(50) NOT NULL,
  `pregunta` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta1` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta2` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta3` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta4` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Esta tabla registra las preguntas de literatura';

--
-- Dumping data for table `preguntas_literatura`
--

INSERT INTO `preguntas_literatura` (`id`, `pregunta`, `respuesta1`, `respuesta2`, `respuesta3`, `respuesta4`) VALUES
(1, '¿Qué es lo que le da sustento al desarrollo de un ensayo académico?', '*Los argumentos.', 'Las referencias.', 'Los ejemplos.', 'Las conclusiones.'),
(2, 'Un sinónimo de la palabra remanso es:', 'Alerta.', '*Quietud.', 'Comodidad.', 'Movilidad.'),
(3, 'En el cuento se emplean pocos personajes debido a:', 'El tiempo.', 'La descripción.', 'El narrador.', '*La brevedad.'),
(4, 'Es la estructura en la que se presenta la historia en un cuento:', '*Exposición, nudo, clímax, desenlace', 'Exposición, clímax, nudo, desenlace', 'Exposición, desenlace, nudo, clímax', 'Exposición, nudo, desenlace, clímax'),
(5, '¿Cuál de las siguientes características pertenece a la poesía de ruptura?', 'La rima asonante.', 'La presencia de aliteraciones.', 'El tratamiento de temas como amor, naturaleza y muerte.', '*La ausencia de rima.'),
(6, 'El recurso literario donde mediante letras se expresan sonidos del ambiente, es conocido como..', '*Onomatopeya.', 'Metáfora.', 'Símil.', 'Anáfora.'),
(7, '¿Quién escribió el libro “Las batallas en el desierto”?', 'Jorge Luis Borges.', '*Jose Emilio Pacheco.', 'Julio Cortazar', 'Octavio Paz.'),
(8, 'Cuando la historia comienza narrando lo acontecido al final, hablamos que está escrita en…', 'In media res.', 'Flash sideway.', '*In extrema res.', 'In final res.'),
(9, '¿Qué recurso literario requiere de dos oraciones que se interponen una a la otra?', 'Paradoja.', 'Oxímoron.', 'Etopeya.', '*Antítesis.'),
(10, 'Cuando la narración es en primera persona, y está narrando sus aventuras como personaje secundario,  ¿De qué tipo de narración hablamos?', 'Intradiegético.', '*Homodiegético.', 'Polifónico.', 'Ficcional.'),
(11, '¿Cuál de las siguientes características, le pertenece a los haikus?', 'Son de origen inca.', 'Tienen rima.', '*Se componen de 17 sílabas.', 'Forman una figura con sus versos.'),
(12, 'Las descripciones en el cuento o en cualquier texto literario narrativo se identifican a través de:', 'Las preposiciones.', 'Los verbos.', 'Los guiones.', '*Los adjetivos.'),
(13, '¿Qué género narrativo se encarga de contar una historia con un fin moral?', 'Leyenda.', 'Cuento.', '*Fábula.', 'Novela.'),
(14, '¿Qué recurso literario exagera el mensaje que se desea entregar al lector?', 'Topografía.', '*Hipérbole.', 'Prosopopeya.', 'Polisíndeton.'),
(15, '¿Cuál de los siguientes autores perteneció al “boom” latinoamericano?', 'Miguel de Cervantes Saavedra.', 'Augusto Roa Bastos.', 'Juan Rulfo.', '*Carlos Fuentes.'),
(16, 'Un ejemplo de dicotomía sería…', '*El cielo y el infierno.', 'La paz y el amor.', 'Lo desconocido y lo explorable.', 'Lo verdadero y lo irrefutable.'),
(17, 'Cuando establecemos una relación partiendo de un punto entre 2 cosas diferentes, hablamos de un…', '*Símil.', 'Anáfora.', 'Comparación.', 'Yuxtaposición.'),
(18, 'En los cuentos donde el personaje principal nos cuenta sus aventuras de manera directa, el tipo de narrador es…', 'Heterodiegético.', 'Homodiegético.', 'Intradiegético.', '*Autodiegético. '),
(19, 'Los dos grupos en los cuales podemos clasificar a las figuras literarias son…', 'De dicción y de expresión', '*De significado y de dicción.', 'De sonido y de visión.', 'De pensamiento y de pensamiento.'),
(20, '¿En qué civilización antigua tiene origen el teatro qué conocemos hoy en día?', 'En Mesopotamia.', 'En la Roma occidental.', 'En el antiguo Egipto.', '*En la antigua Grecia.'),
(21, '¿Cuál de las siguientes figuras literarias NO se presenta en la poesía tradicional?', 'Metáfora.', 'Aliteración.', '*Fusión.', 'Prosopopeya.'),
(22, 'A pesar de haber desarrollado parte de su carrera literaria en México, Roberto Bolaño fue un autor de origen…', '*Chileno.', 'Peruano.', 'Boliviano.', 'Español.'),
(23, '¿En cuántas partes se divide el Quijote?', '6 partes', '*2 partes', '5 partes', '4 partes'),
(24, '¿Cuál de estos autores es representante del Realismo mágico en México?', 'Julio Cortazar.', 'Fernando Pessoa.', 'Carlos Fuentes.', '*Juan Rulfo.'),
(25, '¿A qué género literario destacó Gabriel Garcia Marquez?', 'Surrealismo.', 'Futurismo.', '*Realismo mágico.', 'Postmodernismo.'),
(26, 'El cuento “La culpa es de los tlaxcaltecas”, fue escrito por la autora…', '*Elena Garro.', 'Isabel Allende.', 'Rosario Castellanos.', 'Gabriela Mistral'),
(27, 'El dios griego al cual iban los ritos que dieron origen al teatro era…', 'Apolo.', '*Dionisio.', 'Hércules.', 'Zeus'),
(28, 'El grupo de personajes que aparece en más de una escena, pero la historia no gira en torno a ellos son…', 'Los personajes terciarios.', 'Los personajes ambientales.', '*Los personajes secundarios.', 'Los personajes incidentales.'),
(29, '¿Con cuántas sílabas cuenta el verso “aire sobre la hoja,”?', 'Cinco.', '*Seis.', 'Siete.', 'Ocho.'),
(30, 'El último premio nobel de literatura entregado a un autor latinoamericano fue a…', 'Mario Benedetti', 'Pablo Neruda', 'Octavio Paz', '*Mario Vargas Llosa');

-- --------------------------------------------------------

--
-- Table structure for table `preguntas_morfo`
--

CREATE TABLE `preguntas_morfo` (
  `id` int(50) NOT NULL,
  `pregunta` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta1` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta2` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta3` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta4` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Esta tabla registra las preguntas de literatura';

--
-- Dumping data for table `preguntas_morfo`
--

INSERT INTO `preguntas_morfo` (`id`, `pregunta`, `respuesta1`, `respuesta2`, `respuesta3`, `respuesta4`) VALUES
(1, '¿Cuántos huesos tiene un ser humano adulto promedio?', '215 huesos.', '305 huesos.', '229 huesos.', '*206 huesos.'),
(2, 'La rama de la biología encargada del estudio de la estructura de los seres vivos es…', 'Nanotecnología.', '*Anatomía.', 'Fisiología.', 'Morfología.'),
(3, '¿Cómo se le denomina a la unidad funcional de los riñones?', 'Neuronas.', '*Nefronas.', 'Alveolos.', 'Nefrolos.'),
(4, 'La enfermedad crónica que obstruye las vías respiratorias por tapones de mucosa sin causa definida es …', '*ASMA.', 'EPOC.', 'Enfermedad de Crohn.', 'Divertículos.'),
(5, '¿En qué tipo de diabetes se presenta una resistencia a la absorción de insulina?', '*Tipo 2.', 'Tipo 1.', 'Insulinodependiente.', 'Poliinsulínica.'),
(6, '¿Con qué órgano comienza el proceso de la respiración?', 'Tráquea.', 'Laringe.', '*Nariz.', 'Pulmones.'),
(7, 'El sufijo -algia en medicina lo utilizamos para referirnos a la sensación de…', 'Contracción.', '*Dolor.', 'Amor.', 'Inflamación. '),
(8, '¿Cuál es el tejido más grande del cuerpo humano?', '*La piel.', 'El corazón.', 'El hígado.', 'El páncreas.'),
(9, '¿Cuáles de estos elementos NO se producen en la Hematopoyesis?', 'Glóbulos blancos', 'Glóbulos rojos', 'Plaquetas', '*Minerales'),
(10, 'En promedio ¿Cuántos litros de sangre bombea el corazón por minuto?', '3-4 litros de sangre por minuto.', '7-9 litros de sangre por minuto.', '*4-6 litros de sangre por minuto.', '5-8 litros de sangre por minuto.'),
(11, '¿Cuál es el sistema encargado de la secreción de hormonas para la regulación del organismo?', 'Sistema musculatorio.', '*Sistema endócrino.', 'Sistema óseo.', 'Sistema respiratorio.'),
(12, '¿Cuál de estos sistemas NO interviene en la movilidad del organismo?', '*Sistema endócrino.', 'Sistema óseo', 'Sistema muscular.', 'sistema articular.'),
(13, 'La fisiología patológica estudia principalmente…', 'Las modificaciones que sufren las estructuras enfermas.', 'Las relaciones entre los humanos y los animales. ', '*Las modificaciones que sufren las funciones de las estructuras enfermas.', 'Las funciones de un humano sano.'),
(14, 'El sistema circulatorio se compone de…', 'El corazón, los pulmones y la tráquea.', 'Los riñones, las arterias y las venas.', 'Los huesos, las articulaciones y los músculos.', '*El corazón, las venas y las arterias.'),
(15, 'El nivel tisular estudia de los seres vivos el conjunto de _______ que los conforman.', 'Células.', '*Tejidos', 'Moléculas.', 'Átomos.'),
(16, 'El plano sagital divide al ser humano para su estudio en…', 'Mitad anterior y mitad ventral.', '*Mitad izquierda y mitad derecha..', 'Mitad superior y mitad inferior.', 'Mitad dorsal y mitad caudal.'),
(17, 'Los órganos blanquecinos y duros que forman el esqueleto son…', 'Los músculos.', 'Los tejidos.', 'Las fibras.', '*Los huesos.'),
(18, '¿Cuál es el único dedo que cuenta con solo 2 falanges?', 'El anular.', 'El índice.', '*El pulgar.', 'El meñique.'),
(19, '¿Cuál de las siguientes funciones NO se encarga el sistema óseo?', '*Dotar de movilidad al organismo.', 'Dotar de forma al organismo.', 'Proteger órganos importantes.', 'Sostener al organismo.'),
(20, '¿Desde qué año se emplea la cartilla de vacunación para registrar las inmunizaciones aplicadas a los infantes?', '1969.', '*1979.', '1982.', '1972.'),
(21, 'La faringe es un conducto presente en el cuerpo humano con funciones en los sistemas…', '*Digestivo y respiratorio.', 'Circulatorio y endocrino.', 'Respiratorio y óseo.', 'Digestivo y nervioso.'),
(22, 'El sistema encargado de producir el líquido donde se liberan las sustancias de desecho es…', 'El sistema nervioso.', 'El sistema límbico.', 'El sistema angiológico.', '*El sistema urinario.'),
(23, 'El desarrollo del sistema reproductor comienza en …', 'La etapa de la juventud.', '*La etapa de la pubertad.', 'La etapa de la infancia.', 'La etapa de la adultez..'),
(24, 'Los ciclos menstruales se repiten aproximadamente cada…', '*28 días.', '30 días,', '21 días.', '45 días.'),
(25, '¿Cuánto vive un espermatozoide después de ser fecundado?', 'De 24 a 36 horas.', 'De 2 a 4 horas.', '*De 48 a 72 horas.', 'De 8 a 16 horas.'),
(26, 'Aproximadamente ¿Cuántos días dura un embarazo común?', '400 días.', '360 días.', '270 días.', '*280 días.'),
(27, 'En la actualidad. ¿Cuál es el tipo de pruebas de embarazo más utilizado?', 'Exámenes de gabinete', 'Pruebas terapéuticas.', '*Pruebas inmunológicas.', 'Pruebas biológicas.'),
(28, '¿En cuántas cavidades se divide el abdomen para su estudio?', '3 cavidades.', '*9 cavidades.', '8 cavidades.', '6 cavidades.'),
(29, 'También presentó polifagia lo que significa demasiada:', 'Sed.', '*Hambre. ', 'Orina. ', 'Fatiga.'),
(30, '¿Cómo se le llama a la capa externa del corazón?', 'Endocardio', 'Miocardio', '*Pericardio', 'Ontocardio');

-- --------------------------------------------------------

--
-- Table structure for table `preguntas_quimica`
--

CREATE TABLE `preguntas_quimica` (
  `id` int(50) NOT NULL,
  `pregunta` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta1` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta2` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta3` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `respuesta4` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Esta tabla registra las preguntas de literatura';

--
-- Dumping data for table `preguntas_quimica`
--

INSERT INTO `preguntas_quimica` (`id`, `pregunta`, `respuesta1`, `respuesta2`, `respuesta3`, `respuesta4`) VALUES
(1, '¿Cuál es la parte más pequeña de la materia que participa en reacciones químicas?.', 'Proton.', 'Neutrón.', '*Átomo.', 'Compuesto.'),
(2, '¿Cuál es el elemento más importante que compone a las baterías de nuestros dispositivos electrónicos?', 'Plomo', 'Potasio', 'Manganeso', '*Litio'),
(3, '¿Qué científico propuso el modelo atómico con niveles energéticos para los electrones?', 'Albert Einstein.', '*Niels Bohr.', 'Ernest Rutherford .', 'John Dalton.'),
(4, 'El modelo atómico apodado “budín con pasas” por sus detractores, fue el modelo postulado por…', 'James Chadwick.', '*J.J. Thompson.', 'Erwin Schrödinger.', 'Rudolf Clausius.'),
(5, 'Cuando hablamos de un isótopo, ¿qué partícula subatómica varió?', 'El número de moléculas.', 'El número de electrones.', '*El número de neutrones.', 'El número de protones.'),
(6, '¿Cuál es un ejemplo de mezcla homogénea?', 'Una suspensión. ', 'El azúcar.', 'Un jugo.', '*El acero '),
(7, '¿Cómo se le llama a un conjunto de muchos átomos iguales?', 'molécula.', 'isótopo.', 'alótropo.', '*elemento.'),
(8, '¿Quién fue el descubridor del neutrón?', '*James Chadwick.', 'J.J. Thompson.', 'Erwin Schrödinger.', 'Rudolf Clausius.'),
(9, 'Para calcular la entalpía de una reacción mediante el proceso de entalpía de enlace, requerimos que estén en estado…', 'Sólido.', 'Líquido.', '*Gaseoso.', 'Plasmático.'),
(10, 'El padre de la química contemporánea es…', '*Antoine Lavoisier.', 'Albert Einstein.', 'Aristóteles.', 'Dimitri Mendeleiev.'),
(11, 'El elemento más ligero en la tabla periódica es el …', '*Hidrógeno.', 'Oxígeno.', 'Cloro.', 'Azufre.'),
(12, 'El diamante y el grafito son alótropos del …', 'Ozono.', '*Carbono.', 'Hidrógeno.', 'Calcio.'),
(13, 'El número cuántico que se puede asociar fácilmente con su periodo en la tabla periódica es el…', 'Azimutal', 'De giro', '*Principal', 'Magnético'),
(14, '¿Qué diferencia a un peróxido de un óxido?', 'Que solo se realiza con un metal.', 'Que uno se lleva a cabo de manera orgánica y el otro de forma inorgánica.', '*Que cuenta con un enlace O-O.', 'Que solo se realiza entre no metales.'),
(15, 'Para realizar el cálculo correcto del número atómico ¿qué dato debemos de considerar?', 'El número de quarks.', 'El número de electrones.', 'El número de neutrones.', '*El número de protones.'),
(16, '¿Qué tipo de reacción tiene como producto principal un carbonato o un bicarbonato?', '*Reacción de efervescencia.', 'Reacción de descomposición.', 'Reacción de combustión.', 'Reacción endotérmica.'),
(17, '¿Qué unidad de medida utilizamos cuando hablamos de cantidad de sustancia?', '*El mol.', 'El gramo.', 'El kilogramo.', 'El litro.'),
(18, '¿Cuál de estos elementos se encuentra en estado diatómico de manera natural?', 'Plomo.', 'Zinc.', '*Oxígeno.', 'Cobalto.'),
(19, '¿Cómo se le denomina al átomo que presenta una carga eléctrica?', 'Un isótopo.', '*Un ión.', 'Un alótropo.', 'Un elemento.'),
(20, '¿En qué país se encuentra la reserva de litio más grande del mundo?', 'Turquía.', 'Guatemala.', '*Bolivia.', 'Ecuador.'),
(21, '¿Cuál de los siguientes compuestos es una sal sencilla?', 'Clorato de potasio.', '*Cloruro de manganeso.', 'Ácido clorhídrico.', 'Hidróxido de sodio.'),
(22, '¿Cuál de los siguientes científicos fue el primero en desarrollar la primera batería plomo-ácido?', 'Thomas Davenport.', 'Bradley Dack.', '*Gaston Plante.', 'Antoine Green.'),
(23, '¿Cuál de estos elementos es la base de la química orgánica?', '*Carbono.', 'Oxígeno.', 'Hidrógeno.', 'Cloro.'),
(24, '¿Cómo se le denomina al enlace que está conformado por un metal y un no metal?', 'Enlace Metálico.', '*Enlace iónico.', 'Enlace Polar.', 'Enlace Covalente.'),
(25, '¿En qué año Mario Molina obtuvo el premio nobel de química?', '1994', '1996', '1998', '*1995'),
(26, 'Cuando en un cálculo de entalpía notamos que el resultado es negativo, nos quiere decir que en la reacción…', 'Se absorbió energía.', 'Se redujo la materia.', '*Se liberó energía.', 'Se expandió la materia.'),
(27, '¿Cuántos electrones debe de haber para que se forme un enlace?', '1 electrón.', '*2 electrones.', '3 electrones.', '5 electrones.'),
(28, '¿Qué biomolécula aporta más energía al organismo?', 'Los carbohidratos.', '*Los lípidos.', 'Las proteínas.', 'Los minerales.'),
(29, '¿Cuál de estos NO es síntoma de deshidratación?', '*Pérdida de cabello.', 'Orina de color oscuro.', 'Fatiga.', 'Micción menos frecuente.'),
(30, 'El modelo atómico más aceptado en la actualidad fue propuesto por…', 'Albert Einstein.', 'Niels Böhr.', 'John Dalton.', '*Erwin Schrödinger.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `preguntas_biologia`
--
ALTER TABLE `preguntas_biologia`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `preguntas_derecho`
--
ALTER TABLE `preguntas_derecho`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `preguntas_fisica`
--
ALTER TABLE `preguntas_fisica`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `preguntas_literatura`
--
ALTER TABLE `preguntas_literatura`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `preguntas_morfo`
--
ALTER TABLE `preguntas_morfo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `preguntas_quimica`
--
ALTER TABLE `preguntas_quimica`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `preguntas_biologia`
--
ALTER TABLE `preguntas_biologia`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `preguntas_derecho`
--
ALTER TABLE `preguntas_derecho`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `preguntas_fisica`
--
ALTER TABLE `preguntas_fisica`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `preguntas_literatura`
--
ALTER TABLE `preguntas_literatura`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `preguntas_morfo`
--
ALTER TABLE `preguntas_morfo`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `preguntas_quimica`
--
ALTER TABLE `preguntas_quimica`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
