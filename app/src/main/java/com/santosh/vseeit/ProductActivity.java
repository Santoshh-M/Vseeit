package com.santosh.vseeit;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import static com.santosh.vseeit.MainActivity.showCart;

public class ProductActivity extends AppCompatActivity {
    private ViewPager proimgviewpager;
    private TextView productTitle;
    private TextView avgratings;
    private TextView ttlrates;
    private TextView productprc;
    private TextView cuttedprc;
    private ImageView imgcod;
    private TextView tvcodindi;
    private TabLayout viewpagerIndi;
    private Button coupon;

    //
    private ImageView rewicon;
    private TextView rewtitle;
    private TextView rewbody;
    //

    private FirebaseFirestore ffstore;

    /////product description
    private ConstraintLayout productdetailsonlycontainer;
    private ConstraintLayout productdetailstabcontainer;
    private ViewPager productDetailsviewpager;
    private TabLayout productDetailsTablayout;
    private TextView productOnlyDescritpion;
    /////product description

    /////rating layout
    private LinearLayout ratenow;
    private TextView totlrating;
    private TextView avgrate;

    /////rating layout
    private static boolean ALREADY_ADDED_TO_WISH = false;
    private FloatingActionButton addtowish;
    private LinearLayout ratingsNo;
    private TextView ttlratingfigure;
    private LinearLayout ratingprogresscontainer;
    private LinearLayout ratingsprobar;

    ///Buying
    private TextView Addtocart;
    private Button buynow;
    ///Buying

    /////coupon_dialog
    public static TextView coupontitle;
    public static TextView couponexdate;
    public static TextView couponbody;
    private static RecyclerView cpncycle;
    private static LinearLayout select;
    /////coupon_dialog

    private static List<ProductSpecificationModel> productSpecificationModelList = new ArrayList<>();
    private static String productDescription;
    private static String productOtherdetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        proimgviewpager = findViewById(R.id.pro_images_vwpager);
        viewpagerIndi = findViewById(R.id.viewpager_indicator);
        addtowish = findViewById(R.id.adtowish);
        productDetailsviewpager = findViewById(R.id.product_details_viewpager);
        productDetailsTablayout = findViewById(R.id.product_details_tablayout);
        coupon = findViewById(R.id.coupn_red_btn);
        Addtocart = findViewById(R.id.addtocart);
        buynow = findViewById(R.id.buy_now);
        productTitle = findViewById(R.id.product_Title);
        avgratings = findViewById(R.id.tv_pro_rating_miniv);
        ttlrates = findViewById(R.id.ttl_rate_miniv);
        productprc = findViewById(R.id.pro_price);
        cuttedprc = findViewById(R.id.cutted_price);
        imgcod = findViewById(R.id.cod_indi);
        tvcodindi = findViewById(R.id.tv_cod_indi);
        rewicon = findViewById(R.id.reward_icon);
        rewtitle = findViewById(R.id.reward_title);
        rewbody = findViewById(R.id.reward_body);
        productdetailstabcontainer = findViewById(R.id.product_details_tabcontainer);
        productdetailsonlycontainer = findViewById(R.id.pro_details_container);
        productOnlyDescritpion = findViewById(R.id.pro_det_body);
        totlrating = findViewById(R.id.ttl_rates);
        ratingsNo = findViewById(R.id.ratings_total);
        ttlratingfigure = findViewById(R.id.ttl_ratings);
        ratingprogresscontainer = findViewById(R.id.ratings_prog_container);
        avgrate = findViewById(R.id.avarage_rating);

        ffstore = FirebaseFirestore.getInstance();
        final List<String> productImgs = new ArrayList<>();
        ffstore.collection("PRODUCTS").document("K2BgF3KbAOhbWagKvRnC")
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot documentSnapshot = task.getResult();

                            for (long s = 1; s < (long) documentSnapshot.get("no_of_prouct_images") + 1; s++) {
                                productImgs.add(documentSnapshot.get("product_img_" + s).toString());
                            }
                            ProductimagesAdapter productimagesAdapter = new ProductimagesAdapter(productImgs);
                            proimgviewpager.setAdapter(productimagesAdapter);

                            productTitle.setText(documentSnapshot.get("product_title").toString());
                            avgratings.setText(documentSnapshot.get("avg_rating").toString());
                            ttlrates.setText("(" + (long) documentSnapshot.get("total_ratings") + ")ratings");
                            productprc.setText("\u20b9 " + documentSnapshot.get("product_price").toString() + "/-");
                            cuttedprc.setText("\u20b9 " + documentSnapshot.get("cutted_price").toString() + "/-");

                            if ((Boolean) documentSnapshot.get("COD")) {
                                imgcod.setVisibility(View.VISIBLE);
                                tvcodindi.setVisibility(View.VISIBLE);
                            } else {
                                imgcod.setVisibility(View.INVISIBLE);
                                tvcodindi.setVisibility(View.INVISIBLE);
                            }

                            rewtitle.setText((long) documentSnapshot.get("free_coupons") + documentSnapshot.get("free_coupons_title").toString());
                            rewbody.setText(documentSnapshot.get("free_coupons_body").toString());

                            if ((boolean) documentSnapshot.get("use_tab_layout")) {
                                productdetailstabcontainer.setVisibility(View.VISIBLE);
                                productdetailsonlycontainer.setVisibility(View.GONE);
                                productDescription = documentSnapshot.get("product_description").toString();

                                productOtherdetails = documentSnapshot.get("product_other_details").toString();

                                for (long n = 1; n < (long) documentSnapshot.get("total_spec_title") + 1; n++) {
                                    productSpecificationModelList.add(new ProductSpecificationModel(0, documentSnapshot.get("spec_title_" + n).toString()));
                                    for (long a = 1; a < (long) documentSnapshot.get("spec_title_"+n+"_ttl_fields") + 1; a++) {
                                        productSpecificationModelList.add(new ProductSpecificationModel(1, documentSnapshot.get("spec_title_" +n+"_field_" +a+ "_name").toString(), documentSnapshot.get("spec_title_" +n+ "_field_" +a+ "_value").toString()));
                                    }
                                }
                            } else {
                                productdetailstabcontainer.setVisibility(View.GONE);
                                productdetailsonlycontainer.setVisibility(View.VISIBLE);
                                productOnlyDescritpion.setText(documentSnapshot.get("product_description").toString());
                            }
                            totlrating.setText((long) documentSnapshot.get("total_ratings") + "ratings");
                            for (int c = 0; c < 5; c++) {
                                TextView rating = (TextView) ratingsNo.getChildAt(c);
                                rating.setText(String.valueOf((long)documentSnapshot.get(5-c+"_star")));

                                ProgressBar progressBar = (ProgressBar) ratingprogresscontainer.getChildAt(c);
                                int maxpro = Integer.parseInt(String.valueOf((long) documentSnapshot.get("total_ratings")));
                                progressBar.setMax(maxpro);
                                progressBar.setProgress(Integer.parseInt(String.valueOf((long) documentSnapshot.get((5-c)+"_star"))));
                            }
                            ttlratingfigure.setText(String.valueOf((long) documentSnapshot.get("total_ratings")));
                            avgrate.setText(documentSnapshot.get("avg_rating").toString());
                            productDetailsviewpager.setAdapter(new ProductDetailsAdapter(getSupportFragmentManager(), productDetailsTablayout.getTabCount(),productDescription,productOtherdetails,productSpecificationModelList));

                        } else {
                            String error = task.getException().getMessage();
                            Toast.makeText(ProductActivity.this, error, Toast.LENGTH_LONG).show();
                        }
                    }
                });

        viewpagerIndi.setupWithViewPager(proimgviewpager, true);
        addtowish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ALREADY_ADDED_TO_WISH) {
                    ALREADY_ADDED_TO_WISH = false;
                    addtowish.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#9e9e9e")));
                } else {
                    ALREADY_ADDED_TO_WISH = true;
                    addtowish.setSupportImageTintList(getResources().getColorStateList(R.color.red));
                    }
                }
        });
          productDetailsviewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetailsTablayout));
        productDetailsTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productDetailsviewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        ///////rating layout
        ratenow = findViewById(R.id.rate_str_5);
        for (int x = 0; x < ratenow.getChildCount(); x++) {
            final int starposition = x;
            ratenow.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setRating(starposition);
                }
            });
        }
        final Dialog cpnrdm = new Dialog(ProductActivity.this);
        cpnrdm.setContentView(R.layout.coupon_redeem);
        cpnrdm.setCancelable(true);
        cpnrdm.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ImageView tgopencycle = cpnrdm.findViewById(R.id.toggle_recycleview);
        cpncycle = cpnrdm.findViewById(R.id.coupon_cycle);
        select = cpnrdm.findViewById(R.id.selected_coupon);
        coupontitle = cpnrdm.findViewById(R.id.rew);
        couponexdate = cpnrdm.findViewById(R.id.reward_date);
        couponbody = cpnrdm.findViewById(R.id.reward_body);

        TextView originalprc = cpnrdm.findViewById(R.id.origin_price);
        TextView couponprc = cpnrdm.findViewById(R.id.cupn_prs);

        LinearLayoutManager layoutManager = new LinearLayoutManager(ProductActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cpncycle.setLayoutManager(layoutManager);

        List<RewardModel> rewardModelList = new ArrayList<>();
        rewardModelList.add(new RewardModel("Cashback", "Till 21st, March 2020", "GET 40% CASHBACK on any product above Rs.1000/- and below Rs.3000/-"));
        rewardModelList.add(new RewardModel("Buy one get one", "Till 04st, November 2020", "GET 40% CASHBACK on any product above Rs.1000/- and below Rs.3000/-"));
        rewardModelList.add(new RewardModel("Mega Discount", "Till 08th, October 2020", "GET 40% CASHBACK on any product above Rs.1000/- and below Rs.3000/-"));
        rewardModelList.add(new RewardModel("Special Coupon", "Till 05th, June 2021", "GET 40% CASHBACK on any product above Rs.1000/- and below Rs.3000/-"));
        rewardModelList.add(new RewardModel("Scratch Card", "Till 12th, August 2020", "GET 40% CASHBACK on any product above Rs.1000/- and below Rs.3000/-"));
        rewardModelList.add(new RewardModel("Vseeit Coupon", "Till 25th, April 2050", "GET 40% CASHBACK on any product above Rs.1000/- and below Rs.3000/-"));

        RewardAdapter rw = new RewardAdapter(rewardModelList, true);
        cpncycle.setAdapter(rw);
        rw.notifyDataSetChanged();

        tgopencycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdiacycle();
            }
        });
        ///////rating layout
        coupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cpnrdm.show();
            }
        });
        Addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cart = new Intent(ProductActivity.this, MainActivity.class);
                showCart = true;
                startActivity(cart);
            }
        });
        buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductActivity.this, "Please wait a moment", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void showdiacycle() {
        if (cpncycle.getVisibility() == View.GONE) {
            cpncycle.setVisibility(View.VISIBLE);
            select.setVisibility(View.GONE);
        } else {
            cpncycle.setVisibility(View.GONE);
            select.setVisibility(View.VISIBLE);
        }
    }

    private void setRating(int starposition) {
        for (int s = 0; s < ratenow.getChildCount(); s++) {
            ImageView strbtn = (ImageView) ratenow.getChildAt(s);
            strbtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
            if (s <= starposition) {
                strbtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#FFBF00")));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_cart_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        } else if (id == R.id.main_search_icon) {
            return true;
        } else if (id == R.id.main_cart_icon) {
            Intent cartint = new Intent(ProductActivity.this, MainActivity.class);
            showCart = true;
            startActivity(cartint);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}