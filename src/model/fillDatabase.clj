(ns model.fillDatabase
  
  (:require [clojure.java.jdbc :as j]
            [clojure.java.jdbc.sql :as s]
            [clojure.string :as cs]
         ))

  (defn mysql-db [] 
  (if (.exists (clojure.java.io/as-file "db/my-webapp.h2.db"))
    (println "")
  (j/with-connection
  {:classname "org.h2.Driver"
   :subprotocol "h2:file"
   :subname "db/my-webapp"}

  (j/create-table :news
    [:id "bigint primary key auto_increment"]
    [:title "varchar (255)"]
    [:part "text"]
    [:text "text"]
    [:date "date"]
    [:timesRead "integer"]
    [:genre "varchar (255)"]
    )
  
  (j/insert-records :news
    {:title "Steven Gerrard: I'm not the new Beckham" :part "He might not have the Becks appeal -- but Steven Gerrard says he is ready to light up Hollywood in his own way..." :text "He might not have the Becks appeal -- but Steven Gerrard says he's ready to light up Hollywood in his own way.

While David Beckham brought about a revolution within Major League Soccer with his move to Los Angeles Galaxy in 2007, Gerrard is aiming to leave his own mark after announcing himself on the U.S. stage.

Gerrard made his debut in the 2-1 victory over Mexican side Club America on Sunday, playing 45 minutes for his new side.

But if Galaxy fans are expecting Gerrard to be the new Beckham then they're going to be disappointed -- according to the man himself.

'I'm not here to fill David Beckham's shoes -- they're too big for me to fill,' Gerrard told CNN's Patrick Snell in Los Angeles.

'He's a worldwide icon -- I'm Steven Gerrard. I offer different things and hopefully I offer the same level of success.'

Beckham's arrival in MLS was a seminal moment for the sport in the U.S., his $250 million five-year deal transforming the image of soccer in the country

His departure in 2012, which came after helping Galaxy win the league title, was followed by spells in Europe with AC Milan and Paris Saint-Germain.

Gerrard, who has spent his entire career to date at Liverpool, where he won the European Champions League in 2005, is a vastly different character.

While both are renowned for possessing a magic right-foot, Gerrard does not come with the media circus which Beckham endured during his career.

Beckham and his wife Victoria, the former pop star and now successful fashion designer, lived in LA with their four children, Brooklyn, Romeo, Cruz. and Harper.

Their lives were played out in full glare of the media with paparazzi never far away.

Gerrard is unlikely to court the same amount of attention despite the fanfare surrounding his arrival at the StubHub Center.

The two men, who played together with England, spoke before Gerrard finalized his decision to move to California.

'He just said to me that the timing was right to come and have a new challenge and fresh start' Gerrard added.

'I think it's important that I come to a positive environment that's ready to win. I'm signing for the champions so the future is looking good.'" :date "2015-08-11" :timesRead 5 :genre "sports"})
 
(j/insert-records :news
    {:title "Manchester United faces Club Brugge" :part "Missing out on the Champions League last season, Manchester United appears set to return to the group stage in European football's top club competition after being handed a favorable playoff draw Friday..." :text "Missing out on the Champions League last season, Manchester United appears set to return to the group stage in European football's top club competition after being handed a favorable playoff draw Friday.

The Red Devils could have faced Lazio, Monaco or CSKA Moscow in the two-leg affair but instead were drawn against Club Brugge.

Belgium's top division can't match the quality of Italy, France or Russia and in a further boost to United, the trip to Bruges will be a short one. Club Brugge, the 1978 finalist, finished second last term. 

The three-time champion United is seeking to build on a season where manager Louis van Gaal -- who guided Ajax to Champions League glory in 1995 -- steadied the ship following a turbulent campaign under David Moyes. United secured fourth in the Premier League last season.

Dutch winger Memphis Depay, World Cup winner Bastian Schweinsteiger and French holding midfielder Morgan Schneiderlin have all arrived in the off-season, although standout goalkeeper David de Gea continues to be linked with Real Madrid and Van Gaal confirmed Friday that the Spanish international wouldn't play in Saturday's Premier League opener against Tottenham.

'It is not easy for De Gea to manage his situation now' Van Gaal told reporters Friday before the draw.

The pick of the 10 ties may be two-time finalist Valencia playing Monaco, which upset Arsenal in last season's knockout phase.

If Valencia progresses, Spain would become the first nation to have five teams in the group stage -- by winning last season's Europa League, Sevilla gained an automatic Champions League berth.

Spanish clubs are firmly embedded in Champions League or European Cup history: No one has claimed more than Real Madrid's 10 titles, while Barcelona is the defending champion and owns four titles in the last decade." :date "2015-08-09" :timesRead 4  :genre "sports"})  

(j/insert-records :news
    {:title "Ten-year-old Alzain Tareq makes swimming history" :part "Bahrain's Alzain Tareq has made history by competing at the world swimming championships at the age of 10...." :text "Bahrain's Alzain Tareq has made history by competing at the world swimming championships at the age of 10.

Tareq raced in the women's 50m butterfly, finishing in 41.13 seconds, nine seconds behind the winner and 15 seconds adrift of the fastest qualifier in the heats, her hero Sarah Sjostrom.

She was comfortably the slowest of the 64 competitors in the heats, but she is believed to be the youngest ever swimmer at the world championships and admits she came to Kazan as a learning experience.

'I want to learn the techniques and how they swim' said Tareq, whose mother hails from Scotland. 'I train five days a week, sometimes I train once a day, and sometimes twice.I have school from 7am until 2pm, then I have an hour's rest, then I go home and I study. We have a 50m and a 25m pool in Bahrain. We have about 20 girls who swim, but there are more than 20 boys.'

Despite failing to qualify, she said: 'I'm happy, I feel so happy. It was really cool. I want to swim at the Olympics'." :date "2015-08-07" :timesRead 6  :genre "sports"})  

(j/insert-records :news
    {:title "Carl Lewis says athletes must decide future of the sport" :part "Athletics was rocked by a damning report in The Sunday Times and by German broadcaster ARD/WDR at the weekend that accused the International Association of Athletics Federations of failing to investigate hundreds of what they called 'suspicious' drug tests between 2001 and 2012..." :text "Athletics was rocked by a damning report in The Sunday Times and by German broadcaster ARD/WDR at the weekend that accused the International Association of Athletics Federations of failing to investigate hundreds of what they called 'suspicious' drug tests between 2001 and 2012.

The report raised new questions about the sport just weeks before the world championships in Beijing, which begin in 22 August.

'The future of athleticism depends on the athletes' Lewis said. 'At the end of the day, the sport is going to be as good as the athletes want.'

'If they really want changes, and they want the sport to grow, then they are the ones that have to stand up and work with the powers to make sure it happens.'" :date "2015-08-07" :timesRead 5 :genre "sports"})

(j/insert-records :news
    {:title "Ryan Lochte makes history at World Swimming Championships" :part "Ryan Lochte made history at the World Swimming Championships on Thursday by becoming the first man to win the 200-metre individual medley four successive times..." :text "Ryan Lochte made history at the World Swimming Championships on Thursday by becoming the first man to win the 200-metre individual medley four successive times.

The American trailed through the first three legs, but recovered to end strongly on the freestyle lap and touched first in 1 minute 55.81 seconds. 

It was Lochte's 24th world championship medal - second only to Michael Phelps' career total of 33 - and his 16th gold.

The United States have now won the event seven consecutive times, starting with Phelps' three titles in 2003, 2005 and 2007. 

Lochte picked up the mantle with previous victories in 2009, 2011 and 2013.

Brazil's Thiago Pereira finished second to Lochte in 1:56.65, while China's Wang Shun was third in 1:56.81.

Meanwhile, it was a mixed day for the Great Britain team.

Danny Wallace finished fourth in the men's 200m individual medley while Andrew Willis qualified with the fifth fastest time in the 200m breaststroke.

In the women’s events, Lauren Quigley finished seventh in the final of the 50m backstroke while the relay team finished fifth in the 4x200m freestyle relay, just over five seconds behind the winners the United States.

Friday’s action will include Willis in the 200m breaststroke final, James Guy is involved for Team GB in the men's 4x200m freestyle relay final and Fran Halsall will compete in the women's 50m butterfly heats." :date "2015-08-07" :timesRead 4 :genre "sports"})

(j/insert-records :news
    {:title "Sebastian Coe defends IAAF amid doping claims" :part "Lord Coe denies the IAAF has failed to deal with doping but admits some countries are causing a problem to athletics..." :text "Lord Coe denies the IAAF has failed to deal with doping but admits some countries are causing a problem to athletics.

Coe, running for the IAAF presidency later this month, said there was widespread anger in the sport at claims by German broadcaster ARD and the Sunday Times that athletics had turned a blind eye to hundreds of suspicious blood tests.

The double Olympic 1500m champion insisted the IAAF had led the way on tackling doping and had accepted the embarrassment of banning some of the top athletes from the sport. The IAAF labelled the allegations 'sensationalist and confusing' in a statement on Tuesday.

The Sunday Times has issued a statement standing by its story and calling the IAAF response 'disingenuous'.

It said it had gained access to a database containing more than 12,000 blood tests from 5,000 athletes and that more than 800 athletes - and a third of all medallists in endurance events at recent Olympics and World Championships - had suspicious blood test results which were not followed up by the IAAF.

Asked about his statement that the report was a 'declaration of war', Coe told the BBC: 'I don't think anybody should underestimate the anger that is felt in our sport. We have led the way on this.'" :date "2015-08-07" :timesRead 8 :genre "sports"})


(j/insert-records :news
    {:title "Jamal Crawford Trade Rumors: Latest Buzz and Speculation on Clippers Guard" :part "Jamal Crawford isn't slated to become an unrestricted free agent until the summer of 2016, but he reportedly wouldn't mind switching teams before then..." :text "Jamal Crawford isn't slated to become an unrestricted free agent until the summer of 2016, but he reportedly wouldn't mind switching teams before then. 

According to Northeast Ohio Media Group's Chris Haynes, speaking during Sports Insider, Crawford would be interested in joining the Cleveland Cavaliers.

'I know Jamal personally, and I know he would definitely like to be a part of the Cavaliers organization' Haynes said.

Haynes added: 'Jamal is one guy off the top of my head that I know would be a fit, and I know that they’ll be looking at him. They want to use that exception for a wing player.'

This isn't the first time Crawford has been connected to the reigning Eastern Conference champions. Back on July 6, ESPN.com's Marc Stein reported the Cavaliers and Brooklyn Nets briefly discussed a trade that would have sent Brendan Haywood's non-guaranteed deal to the Los Angeles Clippers in exchange for the veteran microwave scorer.

However, those talks fell through, and Haywood was ultimately dealt to the Portland Trail Blazers in return for two trade exceptions worth $10.5 million and $2.85 million, respectively, per Haynes. 

Haynes' comments come on the heels of Crawford tweeting on July 17 that he aspired to be a free agent.'" :date "2015-08-08" :timesRead 6 :genre "sports"})

(j/insert-records :news
    {:title "Balkan League - Igor Bijelic signs at Kumanovo" :part "KK Kumanovo 2009 (Prva Liga) landed 27-year old Montenegrin power forward Igor Bijelic (207-88)..." :text "KK Kumanovo 2009 (Prva Liga) landed 27-year old Montenegrin power forward Igor Bijelic (207-88). He played most recently at Rabotnicki in FYR Macedonian Prva Liga. In 24 games he averaged 6.6ppg and 3.8rpg last season. Bijelic also spent pre-season at MBK Handlova (Extraliga) in Slovakian league that year.
His team won Macedonian Cup.

The previous (13-14) season he played at Feni Industries. In 22 Prva Liga games he had very impressive stats: 17.6ppg, 8.4rpg and 1.6apg in 2013-14 season.

In 12-13 season Bijelic played at Mladost (Division I) in Bosnia and Herzegovina league. In 34 games he had also remarkable stats: 16.6ppg, 5.9rpg, 1.3apg and 1.1bpg in 2012-13 season. He helped them to make it to the semifinals. It was a very successful season in his career as he was selected to Eurobasket.com All-Bosnia and Herzegovina League Honorable Mention.
In 11-12 season Bijelic played at Servitium (Division II) in Bosnia and Herzegovina league. 

In 19 games he had 8.6ppg, 4.0rpg and 2.8spg in 2011-12 season. Bijelic represented Montenegro at the European Championships U20 in Riga (Latvia) seven years ago. His stats at that event were 6 games: 3.7ppg, 1.8rpg.

Bijelic has played previously professionally in Montenegro (Mornar Bar, Ibon Niksic, Mogren and Danilovgrad) and Serbia (FMP II Beograd)." :date "2015-08-08" :timesRead 9 :genre "sports"})

(j/insert-records :news
    {:title "Simm 11th and Bevan 14th in all-around final" :part "Britain’s Kelly Simm placed 11th and Brinn Bevan 14th and in the European Games artistic gymnastics all-around final in Baku. The titles were taken by Russian legend Aliya Mustafina and Ukraine’s European Champion Oleg Verniaiev..." :text "Britain’s Kelly Simm placed 11th and Brinn Bevan 14th and in the European Games artistic gymnastics all-around final in Baku. The titles were taken by Russian legend Aliya Mustafina and Ukraine’s European Champion Oleg Verniaiev.

Kelly was competing in her first all-around final with an packed and very vocal crowd to contend with. First up on beam she had struggles falling twice which set her back. She then had to regroup quickly and put in a clean floor routine to calm the nerves. On vault – in which she will compete in Saturdays final – she showed her trademark skills to score 14.133 and then ending on bars she performed a new routine which included her own unique element that impressed the judges for a score of 14.226 and total of 51.932 for 11th spot.

Kelly spoke after saying: 'I’m disappointed with my start on beam but I’m happy with how I picked myself up and carried on in my first all-around final. It’s upsetting to fall first routine but then you have to think you have nothing to lose and use it as experience. I was so happy to make the final and very happy with bar today with a new routine and my new release. I’ll be training twice tomorrow with the vault final on Saturday which I’m looking forward to. I’ve never experienced an atmosphere anything like that, it was crazy and maybe I got distracted so I’ll definitely learn from that.'

Brinn is in his first year as a senior having turned 18 this week. He qualified well and that meant he was competing alongside the front runners. His competition began steadily with a nice controlled twisting floor routine followed by a steady pommel display. He then had troubles on his rings dismount not quite able to control his momentum as he fell backwards. On vault Brinn showed his character with a superb routine to score 13.833 and then on parallel bars he was again in top form for 14.733 to take him back up the standings. Ending on high bar unfortunately again there were errors, two falls trying to re-grasp the bar, he showed courage to finish his routine and ended with a total of 82.299 and 14th.

He said after 'It was a great experience being out there with the big names, today wasn't one of my best competitions but it’s a big step – today my idols became my rivals. I tried a couple of new things today, I bettered my floor from qualifying, vault is still new but again landed well and on parallel bars my new dismount went well. I had an unlucky finish on the high bar; the atmosphere was crazy though with the crowd and the other gymnasts supporting me which was amazing. I still have pommel final on Saturday and look forward to being back out there.'" :date "2015-08-12" :timesRead 6 :genre "sports"})

(j/insert-records :news
    {:title "GB ready to make history in Baku" :part "For the gymnastics disciplines of aerobics and acrobatics the European Games are a milestone – the first time these sports will compete within the Olympic family for TeamGB..." :text "For the gymnastics disciplines of aerobics and acrobatics the European Games are a milestone – the first time these sports will compete within the Olympic family for TeamGB.

The Games represent an opportunity to showcase these amazing disciplines and for our British gymnasts the pride of wearing the Olympic rings will be huge, we spoke to Olivia Farrance (pictured second from right) ahead of the aerobic groups qualification in Baku-

'It’s been quiet overwhelming to have been selected, to wear the TeamGB kit see the Olympic rings it’s a very proud achievement for us all. It feels like we’re really starting something, making history for aerobic gymnastics by competing at the biggest event our sport has ever been in. It feels like we’re just at the start and hopefully we can build on this and see aerobics get more and more popular.'

'The European Games will be the biggest competition of our lives by far in terms of the competition. We’ve been training so hard and want to make ourselves proud aiming to make the final. I can’t actually put into words how proud I am to be part of this group and we can’t wait to wear our GBR leotards and show everyone what we can do.'


Want to watch Britain's best aerobic gymnasts live? The 2015 British Gymnastics Championship Series takes place from 30 July to 2 August at Echo Arena, Liverpool." :date "2015-08-09" :timesRead 8 :genre "sports"})

(j/insert-records :news
    {:title "Jennifer Aniston and Justin Theroux marry" :part "After years of waiting and speculation, we can collectively exhale: Jennifer Aniston has finally tied the knot..." :text "After years of waiting and speculation, we can collectively exhale: Jennifer Aniston has finally tied the knot.

Aniston and fellow actor Justin Theroux made it official in an intimate ceremony at home Wednesday, sources told People magazine.

The small Bel Air ceremony included about 70 guests such as Aniston's former 'Friends' co-star Lisa Kudrow, Chelsea Handler and Howard Stern, the magazine reported.

It was a three-year engagement for Aniston, 45, and Theroux, 43, who had been friends for many years before dating, leading observers to routinely wonder whether the couple was breaking up.

Aniston's romantic life has been a focus of the paparazzi since her split from husband Brad Pitt in 2005.

Aniston catapulted into superstardom with her role as Rachel Green on the hit NBC show 'Friends' which aired for 10 years starting in 1994. She won an Emmy for that role. She was nominated for a Golden Globe award for her role in the 2014 movie 'Cake'.

Theroux stars in the HBO series 'The Leftovers' and has had roles in 'Parks and Recreation', 'Six Feet Under' and movies such as 'Zoolander', 'Mulholland Drive' and 'Wanderlust', a 2012 film also starring Aniston. " :date "2015-08-10" :timesRead 12 :genre "showbizz"})

(j/insert-records :news
    {:title "Jon Stewart signs off 'The Daily Show' with a 'love fest'" :part "Here it is, Jon Stewart's final moment of zen.

On Thursday evening Stewart welcomed viewers to his very last edition of 'The Daily Show', more than 16 years after taking over the satirical newscast and turning it into an American institution..." :text "Here it is, Jon Stewart's final moment of zen.

On Thursday evening Stewart welcomed viewers to his very last edition of 'The Daily Show', more than 16 years after taking over the satirical newscast and turning it into an American institution.

Stewart was joined by some of the people that made the show special over the years. Former correspondents John Oliver, Ed Helms, Steve Carell, Olivia Munn, and many others returned to say farewell.

'I never left, Jon', Carell said. 'Becoming an international superstar was just something I did while waiting for my next assignment'.

There were also videotaped farewells -- some friendly, some not -- from A-listers including CNN's Wolf Blitzer, Hillary Clinton, John McCain, and Fox News host Bill O'Reilly (who called Stewart a 'quitter').

Oliver, who now hosts 'Last Week Tonight', attempted to deliver a lengthy monologue, only to be interrupted by the threat of an upcoming commercial break.

'What the f*** is a commercial?' asked Oliver, whose new show airs on commercial-free HBO.

But 'The Daily Show' saved the best former correspondent for last: Stephen Colbert.

'Is there a party or anything? I brought a lot of people from CBS', quipped Colbert, the next host of 'The Late Show'.

Related: Jon Stewart used last show to help raise $2.2 million for autism.

At one point, Colbert went off script, thanking Stewart for being 'infuriatingly good at his job'.

'We are better people for having known you', Colbert said to an emotional Stewart.

Stewart ended the show by thanking his staff, fans and family.

'This show isn't ending, we're merely taking a small pause in the conversation', Stewart said. 'Rather than saying goodbye or goodnight, I'm just going to say I'm going to go get a drink ... so here it is, my moment of zen'.

This led to one of Stewart's all-time favorite musical acts, Bruce Springsteen and the E Street Band, bidding the host farewell with a performance of 'Land of Hopes and Dreams' and 'Born to Run'. 

Zahra Meherali, who was in Thursday's audience, called it a 'love-fest' in the best possible way, describing how the correspondents showered Stewart with affection. 'They were articulating what we wished we could all articulate' as fans, Meherali said." :date "2015-08-12" :timesRead 10 :genre "showbizz"})

(j/insert-records :news
    {:title "Dr. Dre donating new album royalties to fund arts center in Compton" :part "Dr. Dre has announced that he will be donating all of his artist royalties earned from 'Compton', the pioneering gangsta rapper-producer's long-awaited new album, to help fund a new performing arts and entertainment facility in Compton, California.." :text "Dr. Dre has announced that he will be donating all of his artist royalties earned from 'Compton', the pioneering gangsta rapper-producer's long-awaited new album, to help fund a new performing arts and entertainment facility in Compton, California.

The news was announced Thursday on Beats 1 radio DJ Zane Lowe's program.

'I feel it's the right thing to do and I hope everybody appreciates the work I put into this album', Dre said.

The mogul revealed that he'll be working with Compton Mayor Aja Brown and her office on the center. 'We've reached out to Aja Brown quite a few times in the last month or two', Dre said.

'I've been really trying to do something special for Compton and just couldn't quite figure out what it was. She actually had this idea and she was already in the process of working on it. I said, 'Boom, this is what we should do'.

Dre premiered the album a day early on Apple Music, playing it as a loop Thursday night. The LP officially releases on Friday, August 7th.

Speaking to Lowe, Dre mentioned the help he got from emerging artists on the album.

'The new artists I got like King Mez and Justus, these two guys actually came in and just grinded with me throughout the entire project', Dre said. 'As a matter of fact, most of the lyrics are written by us three. We would just go into the studio, put up the track and for some reason, the stars aligned and we killed it, man'.

The record boasts 16 new Dr. Dre songs and features appearances by Eminem, Kendrick Lamar, Ice Cube, Snoop Dogg, the Game and Xzibit, among others. Its release also signals an end to years of speculation about the release of 'Detox', the long-in-gestation, mythical album which he says he has abandoned.

'Compton', Dre has said, will be his 'grand finale'.

'Compton' is subtitled 'A Soundtrack by Dr. Dre' and serves as a companion piece to the N.W.A biopic 'Straight Outta Compton', which will hit theaters August 14.

'During principal photography, I felt myself going to the studio and being so inspired by the movie that I started recording an album', Dre said on his Beats 1 program 'The Pharmacy' earlier this month. 'I kept it under wraps, and now the album is finished. It's bananas.... I'm really proud of this'.

Regarding why he put the kibosh on 'Detox', Dre explained on 'The Pharmacy' that it wasn't up to snuff.

'This is something you're not gonna hear many artists say', he said. 'The reason 'Detox' didn't come out was because I didn't like it. It wasn't good. I'm gonna keep it all-the-way 1,000 with you, seriously. I worked my ass off on it, I don't think I did a good enough job, and I couldn't do that to my fans and I couldn't do that to myself, to be perfectly honest with you. I just wasn't feeling it'.

'Compton', however, is an album he's proud of. 'I just wanted to do something special for Compton', the producer said." :date "2015-08-11" :timesRead 10 :genre "showbizz"})

(j/insert-records :news
    {:title "They're remaking 'Jumanji,' and the Internet rage is real" :part "'Jumanji', the hit 1995 movie starring Robin Williams, is getting a remake, Sony Pictures announced on Wednesday..." :text "'Jumanji', the hit 1995 movie starring Robin Williams, is getting a remake, Sony Pictures announced on Wednesday.

The original film was about a mysterious board game in which the many animals involved in the game came to life. It was an early CGI-special-effects extravaganza along the lines of 'Jurassic Park'.

Given the current reboot trend in Hollywood, this should not surprise anyone, but reaction to the announcement has been especially harsh on social media.

Williams' death nearly one year ago has some crying that the reboot comes too soon. Meanwhile, Disney has already announced a live-action 'Aladdin', an animated film in which Williams voiced a starring role.

Fans made their outrage evident (as one is wont to do) on Twitter.

'I really don't want that Jumanji remake. Probably because I feel it's too soon after Robin William's death and that's one of my favs'.

Or:

'Hollywood is officially out of ideas with a Jumanji reboot'

Are just some of the tweets.

According to Exhibitor Relations, 'Jumanji' is scheduled for release on Christmas Day, 2016.

" :date "2015-08-11" :timesRead 14 :genre "showbizz"})

(j/insert-records :news
    {:title "Colin Farrell joins Harry Potter spinoff 'Fantastic Beasts'" :part "Colin Farrell is ready to cast a spell..." :text "Colin Farrell is ready to cast a spell.

The Irish actor has joined the cast of Warner Bros.' Harry Potter spin-off 'Fantastic Beasts and Where to Find Them', which will star Eddie Redmayne, Katherine Waterston, Ezra Miller and Alison Sudol.

Farrell will play Graves, a wizard that Newt Scamander (Redmayne) meets in New York. The story centers on Newt's adventures in the secret community of witches and wizards as he attempts to document magical creatures. The events of 'Fantastic Beasts' take place 70 years before Harry Potter reads Newt's book in school. Dan Fogler also was recently cast in the film.

David Yates is directing the return to J.K. Rowling's wizarding world, and Rowling wrote the script.

Potter producer David Heyman is back as producer, this time accompanied by Rowling. Steve Kloves, who wrote seven out of the eight Potter movies, and Lionel Wigram are also producing. The film is set for release on November 18, 2016.

Farrell is currently starring on HBO's second season of 'True Detective'. His latest film, Yargos Lanthimos' 'The Lobster', premiered to critical acclaim at the Cannes Film Festival in May, and won the Jury Prize at the festival. Centering on a world where people must find a mate in 45 days or be turned into an animal for the rest of their lives, 'The Lobster' also starred Rachel Weisz and John C. Reilly.

Farrell, whose previous credits include 'Saving Mr. Banks', 'Horrible Bosses' and 'Seven Psychopaths', has also shot thriller 'Solace', opposite Anthony Hopkins. He's repped by CAA, LBI Entertainment and attorney Steve Warren" :date "2015-08-08" :timesRead 13 :genre "showbizz"})

(j/insert-records :news
    {:title "Keith Richards riffs: 'Sgt. Pepper's' was 'a mishmash of rubbish'" :part "The Beatles' 'Sgt. Pepper's Lonely Hearts Club Band' may be regularly ranked among the greatest albums of all time, but it's nowhere near the top of Keith Richards' list..." :text "The Beatles' 'Sgt. Pepper's Lonely Hearts Club Band' may be regularly ranked among the greatest albums of all time, but it's nowhere near the top of Keith Richards' list.

In an interview with Esquire, the Rolling Stones guitarist dismissed the 1967 classic as 'a mishmash of rubbish.'

'There's not a lot of roots in that music. I think they got carried away. Why not? If you're the Beatles in the '60s, you just get carried away -- you forget what it is you wanted to do', he told Esquire's Scott Raab. 'You're starting to do 'Sgt. Pepper.

Some people think it's a genius album, but I think it's a mishmash of rubbish, kind of like '(Their) Satanic Majesties,' he said, referring to the Stones' late 1967 album that attempted to out-'Sgt. Pepper' the Beatles, right down to its 3-D Michael Cooper cover.

At some point, the Beatles may have agreed -- perhaps not with the 'rubbish' description, but that they'd gotten carried away.

The 'Let It Be' album started out as 'Get Back', an attempt for the Fab Four to 'get back' to their rock 'n' roll roots with live playing and minimal overdubbing.

Richards has never made any secret of his love for the blues, and he praised the form as the source of all that followed.

'There's something incredibly powerful about the blues -- the raw blues. But then, there isn't a piece of popular music probably that you've heard that hasn't in some weird way been influenced by the blues', he said. 'I think it's probably the original musical form in the world, when it comes down to it.'

Richards praised a number of the original rockers he's had a chance to know, including Chuck Berry, Jerry Lee Lewis and Little Richard.

Not that he had any visions of making it big, he observed.

'To become a musician, that was the dream -- just to get into a band', Richards said. 'You didn't care if you were stuck in the back strumming away. You know, I would have gladly done that. I wouldn't have minded being a sideman, but things turned out another way. Maybe it was the haircut or something.'" :date "2015-08-10" :timesRead 16 :genre "showbizz"})

(j/insert-records :news
    {:title "Mariah Carey may join 'Empire,' gets Walk of Fame star" :part "Mariah Carey finally got a star on the Hollywood Walk of Fame -- and it was accompanied by some big news..." :text "Mariah Carey finally got a star on the Hollywood Walk of Fame -- and it was accompanied by some big news.

Among the guests paying tribute to Carey, 45, on Wednesday was 'Empire' creator Lee Daniels, who said fans should look for the singer in the hit show's second season.

'Watch her on 'Empire,' you guys. She's coming on 'Empire', Daniels told the assembled crowd, according to news reports.

However, The Hollywood Reporter said that no deal is in place for Carey, and Fox -- which airs 'Empire' -- declined to comment.

Daniels directed Carey in 'Precious' and 'Lee Daniels' The Butler'.

Along with Daniels, Carey's guests included her twin 4-year-olds, Monroe and Moroccan. Their antics, including hugs, lap-climbing and yawning, sometimes threatened to upstage their Grammy-winning mother.

But Carey, 45, kept a smile on her face the whole time and was obviously pleased with the honor.

'Oh, my God, this is so overwhelming', she said.

The singer is one of the best-selling musical artists of all time, with more than 200 million records sold, according to her website. Eighteen of her singles have hit No. 1 on the Billboard Hot 100 pop chart." :date "2015-08-11" :timesRead 11 :genre "showbizz"})

(j/insert-records :news
    {:title "Kermit the Frog, Miss Piggy announce split" :part "Gavin and Gwen. Reba and Narvel.Kermit and Miss Piggy?" :text "It's been a rough week in Hollywood for couples, and no breakup has been more shocking than the split of the beloved Muppets, Kermit the Frog and Miss Piggy.

'After careful thought, thoughtful consideration and considerable squabbling, Miss Piggy made the difficult decision to terminate our romantic relationship', the two said on their respective Facebook pages.

;We will continue to work together on television ('The Muppets'/Tuesdays 8pm this fall on ABC) and in all media now known or hereafter devised, in perpetuity, throughout the universe. However, our personal lives are now distinct and separate, and we will be seeing other people, pigs, frogs, et al. This is our only comment on this private matter;, the message continued. 'Thank you for your understanding'.

The two have been a couple for almost 40 years, going back to the days of the syndicated 'Muppet Show'.

Indeed, what makes the split even more difficult is that the two are starring in a new series this fall, 'The Muppets' on ABC. (Not that this breakup would have anything to do with publicizing the show, of course.)

'It's not easy. It's not as easy as being green, I'll tell you that', Kermit told The Guardian.

Neither could resist a poke at the other.

'We can be professionals. Well, one of us can. Me', Kermit added.

'Dating moi is like flying close to the sun', Miss Piggy said at the Television Critics Association gathering Tuesday. 'It was inevitable that Kermit would drop down to the ground while I stayed in the heavens'.

Kermit has rebounded with a porcine ABC assistant, he said. As for Miss Piggy, she was fending off admirers -- and suspicions -- on Twitter." :date "2015-08-12" :timesRead 14 :genre "showbizz"})

(j/insert-records :news
    {:title "Gwen Stefani, Gavin Rossdale announce split" :part "After nearly 13 years of marriage, rockers Gwen Stefani and Gavin Rossdale are splitting up..." :text "After nearly 13 years of marriage, rockers Gwen Stefani and Gavin Rossdale are splitting up.

The music power couple, who wed in 2002, said in a statement Monday that they're planning to divorce.

'While the two of us have come to the mutual decision that we will no longer be partners in marriage, we remain partners in parenthood and are committed to jointly raising our three sons in a happy and healthy environment', the statement said.

'To that end, we respectfully request privacy from the media during this time'." :date "2015-08-10" :timesRead 11 :genre "showbizz"})

(j/insert-records :news
    {:title "'Back to the Future' celebrates 30th anniversary" :part "We've got to go back in time.

'Back to the Future' celebrates its 30th anniversary today, and some of the cast members recently reunited for the milestone..." :text "We've got to go back in time.

'Back to the Future' celebrates its 30th anniversary today, and some of the cast members recently reunited for the milestone.

Christopher Lloyd, Lea Thompson, Donald Fullilove and Claudia Wells attended a screening of the now-classic film at the Hollywood Bowl on Tuesday.

Lloyd told People magazine he continues to be amazed by the film's popularity.

'It's amazing after 30 years that it thrives the way it does and continues to grow', he said. 'Kids who saw it when it first came out are adults with children now, and it's cycling. It just keeps going on. It's extraordinary, and the impact it's had on so many people's lives. It's sort of stunning'.

Lloyd plays Emmett 'Doc' Brown, who invents a time-traveling DeLorean to send Marty McFly, played by Michael J. Fox, back decades in time to help his parents as teens.

The 76-year-old actor said he and Fox had a grand time filming.

'It was love at first sight', Lloyd told People of his collaboration with Fox. 'Everything just happened so easily with Michael. He has a comic flair, very spontaneous, had wonderful energy. It just all came through. And the chemistry we had between each other -- I felt we never had to work for it. It simply existed'." :date "2015-08-12" :timesRead 14 :genre "showbizz"})

(j/insert-records :news
    {:title "Donald Trump axed from event over Megyn Kelly menstruation comment" :part "A major US conservative forum has dropped Donald Trump as a speaker after he suggested a journalist was tough on him because she was menstruating..." :text "A major US conservative forum has dropped Donald Trump as a speaker after he suggested a journalist was tough on him because she was menstruating.

Mr Trump said Fox News anchor Megyn Kelly 'had blood coming out of her eyes, blood coming out of her wherever' when she co-hosted a televised debate.

During the debate, Ms Kelly challenged him on remarks he had made about women.

Red State said Mr Trump would no longer deliver the keynote address at a conference in Atlanta.

Mr Trump was one of 10 Republican presidential candidates in the debate, which was watched by 24 million people.

Early on in the debate, Ms Kelly asked him why voters should elect a man who has called women 'fat pigs, dogs, slobs and disgusting animals'. Mr Trump joked that he only said that about TV personality Rosie O'Donnell before adding: 'I don't have time for total political correctness'.

After the debate, he took to Twitter to say Ms Kelly had 'really bombed' and that she hadn't been 'very good or professional'. He continued his attack on CNN on Friday night, saying Ms Kelly was 'a lightweight' and that he 'couldn't care less about her'. 

He then added: 'You could see there was blood coming out of her eyes, blood coming out of her wherever'." :date "2015-08-10" :timesRead 16 :genre "worldNews"})

(j/insert-records :news
    {:title "How good is a cheap smartphone?" :part "From the £24,000 ($37,470) Vertu Signature S Red Gold Black DLC to the £50 ($78) Rook, the 2015 smartphone market seemingly has a device to suit every wallet.

But do you get what you pay for?" :text "From the £24,000 ($37,470) Vertu Signature S Red Gold Black DLC to the £50 ($78) Rook, the 2015 smartphone market seemingly has a device to suit every wallet.

But do you get what you pay for?

The Vertu comes with a super-robust sapphire display screen and boasts 64GB of internal memory. It has a 13 megapixel camera and also claims to have 300 hours stand-by battery life.

It's a top spec with a top price tag - but before you start selling the family silver you no longer need to dig that deep for a decent smartphone, said CSS Insight analyst Ben Wood.

'I think £200 is a lot of money for a phone now', he told the BBC.

'We have reached a point in smartphone evolution where devices have become 'good enough'.

There are degrees of cheap. If you are not fussy about brand, an Android device is now very easily available indeed.

You can get a decent camera, you can get good performance and a decent processor'.

At the other end of the market mobile operator EE last month launched the Rook smartphone to the UK priced at just £49.

It runs on the Android operating system, has a 5 megapixel camera, and up to 400 hours of stand-by battery life on a single charge - but it has only 8GB of internal memory and that, according to Mr Wood, is a red flag.

'I would be nervous about buying a device with less than 8GB memory - my experience is once you've installed a few apps you soon run out', he told the BBC.

'You are getting very basic functionality'.

Last week Chinese manufacturer OnePlus held the UK launch of its £239 handset, the OnePlus 2.

Like the previous model, the budget phone is marketed as 'invitation only'. Last year all 900,000 people who received an invitation got the phone.

Like the Vertu it has a 13 megapixel camera and the premium version, costing slightly more at £269, also has 64GB memory." :date "2015-08-11" :timesRead 9 :genre "worldNews"})

(j/insert-records :news
    {:title "Islamic State group claims Saudi mosque suicide blast" :part "A suicide bomb attack on a mosque in Saudi Arabia has left 15 people dead, the interior ministry says..." :text "A suicide bomb attack on a mosque in Saudi Arabia has left 15 people dead, the interior ministry says.

A senior Saudi official said the mosque in Abha, close to the Yemeni border, was used by the security forces.

The Islamic State (IS) group says it carried out the attack. The group has already claimed two deadly attacks on Shia mosques in May. Observers say it is the single most deadly attack on Saudi security forces for many years.

Saudi officials said the bomb went off while members of the security forces were in the middle of noon prayers. One interior ministry official told the BBC that most of those killed were members of a Special Weapons and Tactics (Swat) unit. He said at least three mosque employees were also killed, and scores of other people were wounded.

The death toll was initially put at 13, but the interior ministry later said two of the wounded had died. Preliminary investigations indicated the suicide bomber detonated an explosives belt while inside the mosque, interior ministry officials said.

The attack was claimed in online statements by an IS-affiliated group, al-Hijaz Province.

Another group affiliated to IS, Najd Province, said it was behind two suicide attacks in May - the first killed at least 21 people in an attack on a Shia mosque in Qatif governorate and the second, a week later, at a Shia mosque in Dammam, which left four dead.

IS last year urged its Sunni followers in Saudi Arabia to sow sectarian hatred by targeting the minority Shia population.

Last month Saudi authorities arrested 431 suspected members of IS, accusing them of plotting suicide attacks on security forces and mosques in various parts of the country.

Thursday's attack took place close to the border with Yemen, where Saudi Arabia has been waging an intense air and ground war to push back Shia Houthi rebels and restore its ally, President Mansour Abdrabbuh Hadi, to power." :date "2015-08-11" :timesRead 15 :genre "worldNews"})

(j/insert-records :news
    {:title "Deadly Typhoon Soudelor batters Taiwan" :part "Powerful Typhoon Soudelor has swept across Taiwan with strong winds and heavy rain, leaving at least four people dead and four missing..." :text "Powerful Typhoon Soudelor has swept across Taiwan with strong winds and heavy rain, leaving at least four people dead and four missing.

The storm weakened over the island but remains powerful as it heads for China, prompting the evacuation of more than 150,000 people on the mainland's coast. Rail services and flights have been cancelled in the path of the storm, and schools and offices closed. Millions of homes have been left without electricity.

Soudelor - with winds of more than 230km/h (142mph) - made landfall on the eastern coast of Taiwan early on Saturday. It ripped up trees and tore down billboards, and triggered a landslide in at least one village.

Among the victims were an eight-year-old girl and her mother who were swept out to sea. Another 101 people were injured. 'I've never seen such a powerful typhoon in my 60 years', one resident in the eastern Taitung county told Taiwan's Formosa TV.

The typhoon gradually lost its strength as it crossed the island, but was still packing winds of up to 144km/h (89mph) over the strait between Taiwan and China.

Fujian province in south-east China raised its typhoon alert to the highest level, calling it a 'serious threat', with at least 163,000 people evacuated to higher ground. There are reports of more evacuations in neighbouring Zhejiang province." :date "2015-08-12" :timesRead 12 :genre "worldNews"})

(j/insert-records :news
    {:title "Topless 'Bare with us' protest rally in Canada" :part "Hundreds of Canadian woman joined a topless protest march after three sisters were allegedly stopped by police for cycling without shirts..." :text "Hundreds of Canadian woman joined a topless protest march after three sisters were allegedly stopped by police for cycling without shirts.

Saturday's 'Bare with us' march took place in Waterloo, Ontario. The women say that police told them to cover up whilst cycling in the neighbouring town of Kitchener last month. They have filed a formal complaint with the police.

It is legal for women to be topless in Ontario after a court ruling in 1996. Protestors held signs that included the slogans 'They are boobs not bombs, chill out' and 'Nudity isn't sexual'.

The three sisters, Tameera, Nadia and Alysha Mohamed, say that they took their shirts off because it was a hot summer day. However, they allege that a police officer approached them and told them to cover up. But when they challenged this, the officer said he was stopping them for bike safety reasons. One of the sisters is an award nominated Canadian singer under her stage name Alysha Brilla.

'I had no idea how polarizing the issue would be. I thought people wouldn't be so disturbed by the female breast', she told CBC news. 'We just want to advocate and let people know that they do have this right', the singer added.

Ontario passed legislation confirming the right of women to go topless in 1996, after the Ontario Court of Appeal overturned a woman's conviction for removing her shirt. Gwen Jacobs had been fined in 1991, but on appeal the court found that there was 'nothing degrading or dehumanising' about her going topless in public." :date "2015-08-12" :timesRead 9 :genre "worldNews"})

(j/insert-records :news
    {:title "Brazil inflation rate hits 12-year high" :part "Inflation in Brazil has hit a 12-year high of 9.56%, official figures have shown..." :text "Inflation in Brazil has hit a 12-year high of 9.56%, official figures have shown.

The rising cost of electricity, in particular, has pushed the rate to its highest level since November 2003.

The country's central bank targets an inflation rate of 4.5% and has raised interest rates to 14.25% - among the highest of major economies - to combat rising prices.

High inflation is compounding Brazil's economic woes.

According to the International Monetary Fund, the country's economy is set to shrink by 1.5% this year.

Weaker demand for Brazil's commodities, particularly from the slowing Chinese economy, is the main reason behind the slowdown.

The country's President, Dilma Rousseff, is also trying to force through measures to cut the country's deficit by cutting spending and raising taxes.

Brazil is currently the world's seventh largest economy." :date "2015-08-11" :timesRead 14 :genre "worldNews"})

(j/insert-records :news
    {:title "Russia destroys tonnes of foreign food imports" :part "Russia has bulldozed a pile of Western-produced cheese and tonnes of other foodstuffs imported in violation of sanctions..." :text "Russia has bulldozed a pile of Western-produced cheese and tonnes of other foodstuffs imported in violation of sanctions. The country has also steamrollered fruit and burnt a huge pile of bacon.

The actions come a year after Russia banned some Western food products in retaliation to EU and US sanctions applied after Moscow annexed Crimea. The destruction has caused an outcry from anti-poverty campaigners who say it should have been given to the poor.

One steamroller took an hour to crush nine tonnes of cheese. Another consignment was due to be burnt. Boxes of bacon have been incinerated. Peaches and tomatoes were also due to be crushed by tractors. Religious leaders expressed outrage. One called the actions 'insane, stupid and vile'.

Russia has suffered notorious famines in its recent history which saw millions starve. More than 285,000 people have backed an online petition calling on President Putin to give the food away. The petition says that food sanctions have led to higher prices and shortages that are causing real hardship. Food price inflation is running at around 20%.

Former prime minister, Mikhail Kasyanov, said that 20 million Russian citizens were below the poverty line, commenting that destroying food products was 'some real triumph of humanism'. The EU is providing aid for European exporters of dairy produce, fruit and vegetables to ease the impact of the Russian ban on those goods. The EU Commission said last week the 'safety net' for Europe's dairy sector would remain in place until March 2016 and for fruit and vegetable growers until July 2016.

There have been daily road blockades by French farmers - and on Thursday similar protests erupted in Belgium. They want higher prices for their produce, saying they are struggling to stay in business." :date "2015-08-13" :timesRead 12 :genre "worldNews"})

(j/insert-records :news
    {:title "US economy adds 215,000 jobs in July" :part "The US economy added 215,000 jobs in July, while the unemployment rate held at a seven-year-low of 5.3%..." :text "The US economy added 215,000 jobs in July, while the unemployment rate held at a seven-year-low of 5.3%.

The Bureau of Labor Statistics said job gains came in retail trade, health care, professional and technical services, and financial activities. The jobs figures are a seen as a significant gauge of the health of the economy. Analysts said the figures meant a US interest rate rise in September remained a possibility.

Last month, the Federal Reserve upgraded its assessment of the labour market, saying it was continuing to 'improve, with solid job gains and declining unemployment'. Chris Williamson, chief economist at Markit, said: 'With the Fed's decision on the timing of the first rate rise 'data dependent', today's report does nothing to discourage the belief that a September hike is very much on the table, albeit by no means a done deal'.

He said that the new hiring figures 'just missed' expectations of a 225,000 rise. 'Private sector payrolls grew by a solid 210,000, just shy of an expected 215,000 rise, led by service sector hiring alongside gains in the manufacturing and construction sectors', he added. 

The Bureau of Labour Statistics said that 'over the year, the unemployment rate and number of unemployed people were down by 0.9 percentage point and 1.4 million'. Payroll figures from May and June were revised upwards to show 14,000 more jobs created than previously reported. Also, the average working week lengthened to 34.6 hours, the highest since February.

Average hourly earnings increased by five cents, or 0.2%, after being flat in June. The statistics office also said that the number of long-term unemployed (those jobless for 27 weeks or more) was little changed at 2.2 million. These account for 26.9% of the unemployed.

The civilian labour force participation rate was unchanged at 62.6% in July." :date "2015-08-10" :timesRead 11 :genre "worldNews"})

)
    )
   )
  
  