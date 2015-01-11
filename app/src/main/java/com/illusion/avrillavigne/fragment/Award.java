package com.illusion.avrillavigne.fragment;

import java.util.ArrayList;
import com.illusion.avrillavigne.R;
import com.illusion.avrillavigne.adapter.EntryAdapter;
import com.illusion.avrillavigne.adapter.EntryItem;
import com.illusion.avrillavigne.adapter.Item;
import com.illusion.avrillavigne.adapter.SectionItem;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Award extends Fragment {

	ArrayList<Item> items = new ArrayList<Item>();
	ListView listview = null;

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.fragment_award, container, false);
      
       listview = (ListView) rootView.findViewById(R.id.listView_main);
      
       items.add(new SectionItem("AG Canadian Hair Cosmetics Awards"));
       items.add(new EntryItem("Favorite Canadian Musician Hair", "2008"));
       items.add(new EntryItem("Sexiest Hair on a Canadian Musician", "2010"));
              
       items.add(new SectionItem("ASCAP Film and Television Music Awards (2004)"));
       items.add(new EntryItem("Most Performed Song from a Motion Picture", "I'm With You"));
       items.add(new EntryItem("Best Pop Song", "Complicated"));
       
       items.add(new SectionItem("Japan Billboard Music Awards (2012)"));
       items.add(new EntryItem("JAPAN BILLBOARD Pop Artist of the Year", ""));
       items.add(new EntryItem("JAPAN BILLBOARD Hot 100 Airplay of the Year", "What The Hell"));
       
       items.add(new SectionItem("BMI Awards"));
       items.add(new EntryItem("Award-Winning Songs", "Complicated (2003 / 2004)"));
       items.add(new EntryItem("Award-Winning Songs", "I'm With You (2004)"));
       items.add(new EntryItem("Award-Winning Songs", "My Happy Ending (2006)"));
       items.add(new EntryItem("Award-Winning Songs", "When You're Gone (2009)"));
       items.add(new EntryItem("Award-Winning Songs", "What The Hell (2012)"));
       
       items.add(new SectionItem("Brazil Music Awards"));
       items.add(new EntryItem("Breakthrough Artist", "2002"));
       items.add(new EntryItem("Album of the Year", "Let Go (2003)"));
       
       items.add(new SectionItem("Capricho Awards"));
       items.add(new EntryItem("Most Stylish International", "2007"));
       items.add(new EntryItem("International Singer", "2011"));
       items.add(new EntryItem("Most Stylish International", "2011"));
       items.add(new EntryItem("Best Live Concert", "The Black Star Tour (2011)"));
       
       items.add(new SectionItem("CEW Beauty Awards"));
       items.add(new EntryItem("Woman's Secent Mass", "Black Star (2010)"));
       
       items.add(new SectionItem("ChartAttack.com"));
       items.add(new EntryItem("The Throw Your Underwear Female - Most Sexiest Canadian", "2002 / 2005 / 2007 / 2009/ 2010"));
       items.add(new EntryItem("Best Haircut", "2005 / 2009"));
       items.add(new EntryItem("Best Breaking Mirror in a Video", "Don't Tell Me (2005)"));
       items.add(new EntryItem("Stinky Happenings In Music This Year", "2009"));
       items.add(new EntryItem("Best Song", "2010"));
       
       items.add(new SectionItem("CMW Music Industry Awards"));
       items.add(new EntryItem("Canadian Talent Development Story of the Year", "2003"));
       
       items.add(new SectionItem("Comet Music Awards"));
       items.add(new EntryItem("International Artist of the Year", "2004"));
       
       items.add(new SectionItem("Common Sense Media Award"));
       items.add(new EntryItem("Best Musician", "2004"));
       
       items.add(new SectionItem("Danish Music Awards"));
       items.add(new EntryItem("Breakthrough Artist", "2003"));
       
       items.add(new SectionItem("Radio Disney Music Awards (2003)"));
       items.add(new EntryItem("Artist of the Year", ""));
       items.add(new EntryItem("Best Female Artist", ""));
       items.add(new EntryItem("Album of the Year", "Let Go"));
       items.add(new EntryItem("Best Original Song", "Complicated"));
       
       items.add(new SectionItem("ECHO Awards"));
       items.add(new EntryItem("Most Successful Newcomer of the Year, International", "2003"));
       
       items.add(new SectionItem("Entertainment Weekly Magazine"));
       items.add(new EntryItem("Best New Artist album of 2002", "Let Go (2002)"));
       
       items.add(new SectionItem("Gold Disc Award Hong Kong"));
       items.add(new EntryItem("Best 10 Albums", "Let Go (2003)"));
       items.add(new EntryItem("Best 10 Albums", "Under My Skin (2004)"));
       items.add(new EntryItem("Best 10 Albums", "The Best Damn Thing (2007)"));
       items.add(new EntryItem("Best 10 Albums", "Goodbye Lullaby (2011)"));
       
       items.add(new SectionItem("Galgalatz Awards"));
       items.add(new EntryItem("Artist of the Year", "2007"));
       
       items.add(new SectionItem("Huading Awards"));
       items.add(new EntryItem("World's Best Singer", "2013"));
       
       items.add(new SectionItem("IFPI Platinum Europe Awards"));
       items.add(new EntryItem("2 x Platinum", "Let Go (2003)"));
       items.add(new EntryItem("Platinum", "Under My Skin (2004)"));
       items.add(new EntryItem("Platinum", "The Best Damn Thing (2007)"));
       
       items.add(new SectionItem("Imperio Music Awards"));
       items.add(new EntryItem("Artist of the Year", "2004 / 2008"));
       items.add(new EntryItem("Best Female Artist", "2004"));
       items.add(new EntryItem("Video of the Year", "My Happy Ending (2004)"));
       items.add(new EntryItem("Song of the Year", "Girlfriend (2008)"));
       items.add(new EntryItem("Best Pop Video", "Girlfriend (2008)"));
       items.add(new EntryItem("Video of the Year", "When You're Gone (2008)"));
       
       items.add(new SectionItem("Ivor Novello Awards"));
       items.add(new EntryItem("International Hit Of The Year", "Complicated (2003)"));
       
       items.add(new SectionItem("Japan Gold Disc Awards"));
       items.add(new EntryItem("Artist of the Year", "2003 / 2008"));
       items.add(new EntryItem("Rock&Pop Album of the Year", "Let Go (2003)"));
       items.add(new EntryItem("Rock&Pop Album of the Year", "Under My Skin (2005)"));
       items.add(new EntryItem("Music Video Of The Year", "Live at Budokan: Bonez Tour (2006)"));
       items.add(new EntryItem("Album of the Year", "The Best Damn Thing (2008)"));
       items.add(new EntryItem("Best 3 Albums", "The Best Damn Thing (2008)"));
       items.add(new EntryItem("Mastertone of the Year", "Girlfriend (2008)"));
       items.add(new EntryItem("Single Track of the Year (mobile)", "Girlfriend (2008)"));
       items.add(new EntryItem("Best 3 Albums", "Goodbye Lullaby (2012)"));
       
       items.add(new SectionItem("Juno Awards"));
       items.add(new EntryItem("New Artist of the Year", "2003"));
       items.add(new EntryItem("Album of the Year", "Let Go (2003)"));
       items.add(new EntryItem("Pop Album of the Year", "Let Go (2003)"));
       items.add(new EntryItem("Single of the Year", "Complicated (2003)"));
       items.add(new EntryItem("Artist of the Year", "2005"));
       items.add(new EntryItem("Juno Fan Choice Award", "2005"));
       items.add(new EntryItem("Pop Album of the Year", "Under My Skin (2005)"));
       items.add(new EntryItem("Single of the Year", "Young Artists for Haiti: Waving Flag (2011)"));
       
       items.add(new SectionItem("Los Premios MTV Latinoamérica"));
       items.add(new EntryItem("Best New Artist — International", "2002"));
       items.add(new EntryItem("Best Pop Artist — International", "2003 / 2004 / 2007"));
       items.add(new EntryItem("Song of the Year", "Girlfriend (2007)"));
       
       items.add(new SectionItem("MTV Asia Awards"));
       items.add(new EntryItem("Style Award", "2003"));
       items.add(new EntryItem("Favorite Female Artist", "2003"));
       items.add(new EntryItem("Favorite Breakthrough Artist", "2003"));
       items.add(new EntryItem("Favorite Female Artist", "2005"));
       
       items.add(new SectionItem("MTV Taiwan"));
       items.add(new EntryItem("Best International Artist of 2013", "2014"));
       
       items.add(new SectionItem("MTV Europe Music Awards"));
       items.add(new EntryItem("Best Solo", "2007"));
       items.add(new EntryItem("Most Addictive Track", "Girlfriend (2007)"));
       
       items.add(new SectionItem("MTV Fan Music Awards"));
       items.add(new EntryItem("Song of the Year", "What the Hell (2011)"));
       items.add(new EntryItem("Best Movie Song", "Alice (2011)"));
       
       items.add(new SectionItem("MTV Russia Music Awards"));
       items.add(new EntryItem("Best International Act", "2007"));
       
       items.add(new SectionItem("MTV Total Request Live Awards (Italy)"));
       items.add(new EntryItem("First Lady", "2006 / 2008"));
       items.add(new EntryItem("Best Look", "2011"));
       
       items.add(new SectionItem("MTV Video Music Awards"));
       items.add(new EntryItem("Best New Artist", "Complicated (2002)"));
       
       items.add(new SectionItem("MTV Video Music Awards Japan"));
       items.add(new EntryItem("Best New Artist", "2003"));
       items.add(new EntryItem("Best Pop Video", "Girlfriend (2008)"));
       items.add(new EntryItem("Best Video From a Film", "Alice (2011)"));
       
       items.add(new SectionItem("MTVLAs"));
       items.add(new EntryItem("Battle of the Bands", "2011"));
       
       items.add(new SectionItem("Italian MTV WOW Awards"));
       items.add(new EntryItem("Artist saga route 1 ( vs. Demi Lovato)", "2014"));
       
       items.add(new SectionItem("Meteor Awards"));
       items.add(new EntryItem("Best International Female", "2003 / 2005 / 2008"));
       
       items.add(new SectionItem("MuchMusic Video Awards"));
       items.add(new EntryItem("Best International Video By A Canadian", "Sk8er Boi (2003)"));
       items.add(new EntryItem("People's Choice Favourite Canadian Artist", "2003 / 2004 / 2007 / 2008"));
       items.add(new EntryItem("Best International Video By A Canadian", "Don't Tell Me (2004)"));
       items.add(new EntryItem("Best International Video By A Canadian", "Girlfriend (2007)"));
       items.add(new EntryItem("Best International Video By A Canadian", "Here's to Never Growing Up (2013)"));
       
       items.add(new SectionItem("American Nickelodeon Kids' Choice Awards"));
       items.add(new EntryItem("Favorite Song", "Sk8er Boi (2003)"));
       items.add(new EntryItem("Favorite Female Singer", "2004 / 2005"));
       items.add(new EntryItem("Favorite Song", "Girlfriend (2008)"));
       
       items.add(new SectionItem("ITA Nickelodeon Kids' Choice Awards"));
       items.add(new EntryItem("Best International Artist/Band", "2007"));
       items.add(new EntryItem("Favorite Female Singer", "2008 / 2009"));
       
       items.add(new SectionItem("Meus Prêmios Nick"));
       items.add(new EntryItem("Favorite International Artist", "2005"));
       
       items.add(new SectionItem("UK Nickelodeon Kids' Choice Awards"));
       items.add(new EntryItem("Favorite Female Singer", "2007"));
       items.add(new EntryItem("Best Music Video", "Girlfriend (2007)"));
       
       items.add(new SectionItem("NME Carling Awards"));
       items.add(new EntryItem("Most Sexy Woman", "2003"));
       
       items.add(new SectionItem("NRJ Music Awards"));
       items.add(new EntryItem("International New Artist of the Year", "2004"));
       items.add(new EntryItem("Best International Female Artist", "2005 / 2008"));
       
       items.add(new SectionItem("Paja Awards"));
       items.add(new EntryItem("Favorite Female Singer", "2007"));
       items.add(new EntryItem("Single of the Year", "When You're Gone (2007)"));
       
       items.add(new SectionItem("Planeta Awards"));
       items.add(new EntryItem("Best Solo of The Year", "2007"));
       items.add(new EntryItem("Best Balad", "When You're Gone (2007)"));
       
       items.add(new SectionItem("Premios Oye!"));
       items.add(new EntryItem("Best International Album", "Let Go (2003)"));
       items.add(new EntryItem("Breakthrough of the Year", "Let Go (2003)"));
       items.add(new EntryItem("Best International Album", "Under My Skin (2004)"));
       
       items.add(new SectionItem("PortalMix.com"));
       items.add(new EntryItem("Top Ten International Albums", "The Best Damn Thing (2007)"));
       
       items.add(new SectionItem("Canadian Radio Music Awards"));
       items.add(new EntryItem("Best New Solo Artist", "2003"));
       items.add(new EntryItem("Fan's Choice Award", "2003 / 2004 / 2005"));
       items.add(new EntryItem("Socan Songwriter Award", "2003"));
       items.add(new EntryItem("Best New Solo Artist (Rock)", "Losing Grip (2003)"));
       items.add(new EntryItem("Best New Group or Solo Artist", "Complicated (2003)"));
       
       items.add(new SectionItem("US Radio Music Awards"));
       items.add(new EntryItem("Song of the Year (Modern Adult Contemporary Radio)", "Complicated (2003)"));
       items.add(new EntryItem("Artist of the Year (Adult Hit Radio)", "2005"));
       
       items.add(new SectionItem("Radio Hong Kong International Pop Music Awards"));
       items.add(new EntryItem("Most Popular Female Singer", "2003"));
       items.add(new EntryItem("Most Popular New Artist", "2003"));
       items.add(new EntryItem("Best Selling English Album", "Let Go (2003)"));
       items.add(new EntryItem("International Song of the Year", "Complicated (2003)"));
       items.add(new EntryItem("Most Popular Song", "Complicated (2003)"));
       
       items.add(new SectionItem("Rolling Stone Magazine"));
       items.add(new EntryItem("Influential Woman of Year", "2002"));
       
       items.add(new SectionItem("Socan Awards"));
       items.add(new EntryItem("Best Pop Song", "Complicated (2003)"));
       items.add(new EntryItem("Best Pop Song", "I'm with You (2003)"));
       items.add(new EntryItem("Best Pop Song", "Sk8er Boi (2003)"));
       items.add(new EntryItem("Best Pop Song", "Don't Tell Me (2005)"));
       items.add(new EntryItem("Best Pop Song", "My Happy Ending (2005)"));
       items.add(new EntryItem("Best Pop Song", "Nobody's Home (2005)"));
       items.add(new EntryItem("Best Pop Song", "Keep Holding On (2008)"));
       items.add(new EntryItem("Best Pop Song", "When You're Gone (2008)"));
       items.add(new EntryItem("Best Pop Song", "Girlfriend (2008)"));
       
       items.add(new SectionItem("Teen Awards Brasil"));
       items.add(new EntryItem("Cantora International", "2014"));
       
       items.add(new SectionItem("Teen Choice Awards"));
       items.add(new EntryItem("Choice Fashion: Female Icon", "2003"));
       items.add(new EntryItem("Choice Music: Single", "Sk8er Boi (2003)"));
       items.add(new EntryItem("Choice Music: Love Song", "I'm With You (2003)"));
       items.add(new EntryItem("Choice Music: Female Artist", "2004 / 2007"));
       items.add(new EntryItem("Choice Music: Single", "Girlfriend (2007)"));
       
       items.add(new SectionItem("TMF Awards"));
       items.add(new EntryItem("Best Video: International", "Complicated (2003)"));
       items.add(new EntryItem("Best Rock: International", "2003"));
       
       items.add(new SectionItem("VH1 Awards"));
       items.add(new EntryItem("Top 100 Greatest Female Artists", "2011"));
       items.add(new EntryItem("Top 50 Greatest Female Artists Since Music Video Times", "2011"));
       items.add(new EntryItem("Top 100 Greatest Songs", "Complicated (2011)"));
       items.add(new EntryItem("Top 100 Sexiest Artists", "2013"));
       
       items.add(new SectionItem("Virgin Media Music Awards"));
       items.add(new EntryItem("Best International Act", "2007"));
       
       items.add(new SectionItem("VEVOCertified Awards"));
       items.add(new EntryItem("+100.000.000 Views", "Girlfriend (2009)"));
       items.add(new EntryItem("+100.000.000 Views", "What the Hell (2012)"));
       items.add(new EntryItem("+100.000.000 Views", "When You're Gone (2012)"));
       items.add(new EntryItem("+100.000.000 Views", "Wish You Were Here (2012)"));
       items.add(new EntryItem("+100.000.000 Views", "Smile (2014)"));
       
       items.add(new SectionItem("World Music Awards"));
       items.add(new EntryItem("World's Best selling Canadian Pop/Rock Artist of the Year", "2002 / 2003"));
       items.add(new EntryItem("World's Best Selling Pop/Rock Female Artist", "2004 / 2007"));
       items.add(new EntryItem("World's Best Selling Canadian Artist", "2004 / 2007"));
       
       items.add(new SectionItem("Young People Awards"));
       items.add(new EntryItem("Artist of the Year", "2012"));

       EntryAdapter myAdapter = new EntryAdapter(getActivity(), items);
       listview.setAdapter(myAdapter);
       
	   return rootView;
	
   }
}